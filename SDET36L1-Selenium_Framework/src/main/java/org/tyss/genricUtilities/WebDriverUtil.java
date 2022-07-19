package org.tyss.genricUtilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * This class contains all the webdriver actions
 * @author yogi
 *
 */

public final class WebDriverUtil {
	private WebDriver driver;
	private Actions act;

	/**
	 * This method is used to setup the driver instance
	 * @param browser
	 * @return
	 * 
	 */
	public WebDriver setupDriver(String browser) {
		switch (browser) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "ie":
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			break;
		default:
			System.out.println("YOU ENTERED WRONG BROWSER");
			break;
		}
		return driver;


	}

	/**
	 * This method is used to maximize the browser
	 */
	public void maximizeBrowser() {
		driver.manage().window().maximize();

	}
	/**
	 * This method is to wait by implicitlyWait.
	 */
	public void implicitWait(long longTimeout) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(longTimeout));
	}

	/**
	 * this method is to navigate the application
	 * 
	 * @param url
	 */

	public void openApplication(String url) {
		driver.get(url);
	}
	/**
	 * This method is to initalize the actions
	 */
	public void initActions() {
		act= new Actions(driver);

	}
	/**
	 * This method is used to mouse hover on Element
	 * @param
	 */
	public void mouseHoverOnElement(WebElement element) {
		act.moveToElement(element).perform();
	}
	
	
	/**
	 * This Method is for MouseHoverAndClickOperation
	 * 
	 */
	public void mouseHoverOnElementAndClick(WebElement element) {
		act.moveToElement(element).click().perform();
	}

	/**
	 * This method is used to close particular browser
	 */
	public void closeBrowser() {
		driver.quit();
	}
	/**
	 * This method is used to close particular tab
	 */
	public void closeTab() {
		driver.close();
	}
	/**
	 * This method is for moveTo action
	 * @param Element
	 */
	public void moveToElement(WebElement Element) {
		act.moveToElement(Element).perform();	
	}
	/**
	 * This method is for handling frames by using index value
	 * @param Index
	 */
	public void switchFrame(int Index) {
		driver.switchTo().frame(Index);
	}
	/**
	 * This method is for handling frames by using Webelement 
	 * @param Element
	 */
	public void switchFrame(WebElement Element) {
		driver.switchTo().frame(Element);
	}
	/**
	 * This method is for handling frames by using Name or Id
	 */
	public void switchFrame(String NameOrId) {
		driver.switchTo().frame(NameOrId);
	}
	/**
	 * This method is to switchback from frame
	 * 
	 */
	public void switchBackFromFrame(String strategy) {
		switch (strategy.toLowerCase().trim()) {
		case "default":
			driver.switchTo().defaultContent();
			break;
		case "parent":
			driver.switchTo().parentFrame();

		default:
			System.out.println("please enter valid strategy");
			break;
		}
	}
	/**
	 * This method is for RightClickAction
	 */
	public void rightClickAction() {
		act.contextClick().perform();
	}
	/**
	 * This method is for RightClickAction
	 */
	public void rightClickAction(WebElement Element) {
		act.contextClick(Element).perform();
	}
	
	
	/**
	 * This method is to handle select dropdown by visible text
	 */
	public void dropdownByText(WebElement dropdownEle, String visibleText) {
		Select select = new Select(dropdownEle);
		select.selectByVisibleText(visibleText);
	}
	/**
	 * This method is to handle select dropdown by value
	 */
	public void dropdownByValue(String value,WebElement dropdownEle) {
		Select select = new Select(dropdownEle);
		select.selectByValue(value);
	}
	/**
	 * This method is to handle select dropdown by value
	 */
	public void dropdownByIndex(int Index,WebElement dropdownEle) {
		Select select = new Select(dropdownEle);
		select.selectByIndex(Index);
	}
	/**
	 * This method is to take screenshot
	 * 
	 */
	public void takeScreenShotPage(Object currentClass ) {
		
	}
	
	/**
	 * this meythod is to switch the window
	 * @param partialText
	 * @param strategy
	 */
	public void switchWindow(String partialText, String strategy) {
		Set<String> winIds = driver.getWindowHandles();
		for(String id:winIds)
		{
			driver.switchTo().window(id);
			if(strategy.equalsIgnoreCase("url")) {
				if(driver.getCurrentUrl().contains(partialText)) {
					break;
				}
			}
			else if (strategy.equalsIgnoreCase("title")) {
				if(driver.getTitle().contains(partialText)) {
					break;
				}
			}
		}
	}
	/**
	 * This Method is to wait till clickable element(WebdriverWait)
	 * @param totalDuration
	 * @param pollingTime
	 * @param element
	 */
	public void waitTillElementClickable(int totalDuration, long pollingTime, WebElement element) {
		int currentTime=0;
		while(currentTime<=totalDuration) {
			try {
				element.click();
				break;
			
			}
			catch(Exception e) {
				try {
					Thread.sleep(pollingTime);
				}
				catch(Exception e1)
				{
					e.printStackTrace();
				}
			}currentTime++;
		}
	}
	WebDriverWait wait ;
	/**
	 * This method is to intiallize the explicit wait or webdriverwait
	 * @param timeOuts
	 * @param pollingTime
	 */
	public void intiallizeExplicitWait(long timeOuts,long pollingTime) {
		 wait = new WebDriverWait(driver, Duration.ofSeconds(timeOuts));
	wait.pollingEvery(Duration.ofMillis(pollingTime));
	wait.ignoring(Exception.class);
	}
	/**
	 * This method is to init webdriver wait till element visible
	 * @param element
	 */
	public void waitTillElementVisible(WebElement element) {
		wait.until((ExpectedConditions.visibilityOf(element)));
	}
	/**
	 * this method is to wait until invisiblity of element
	 * @param element
	 */
	public void  waitTillElementInvisible(WebElement element) {
		wait.until(ExpectedConditions.invisibilityOf(element));
	}
	/**
	 * This method is to accept the alert popup
	 */
	public void jsPopupAccept() {
		driver.switchTo().alert().accept();
	}
	public void jsPopupDecline() {
		driver.switchTo().alert().dismiss();
	}
	public void jsPopupSendData(String data) {
		driver.switchTo().alert().sendKeys(data);
	}
	public void jsPopupGetText() {
		driver.switchTo().alert().getText();
	}
	/**
	 * This method is to take screenshots of specific element
	 * @param element
	 * @param currentClass
	 * @param javaUtility
	 */
	
	public void takeScreeenShotElement(WebElement element, Object currentClass,JavaUtil javaUtility) {
		File scr = element.getScreenshotAs(OutputType.FILE);
		File dst = new File("./elementScreenShot/"+currentClass.getClass().getSimpleName()+javaUtility.getCurrentDate("dd_MM_yyyy_HH_mm_sss"));
       
		try {
			FileUtils.copyFile(scr, dst);
		} catch (IOException e) {
			e.printStackTrace();
		}
		

		
	}
	
	
	

}