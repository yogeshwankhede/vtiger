package org.vtiger.contacts;

import java.time.Duration;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.tyss.genricUtilities.ExcelOperationsUtil;
import org.tyss.genricUtilities.FileOperationsUtil;
import org.tyss.genricUtilities.IConstantUtils;
import org.tyss.genricUtilities.JavaUtil;
import org.tyss.genricUtilities.WebDriverUtil;
import org.vtiger.practices.Jdbc_Base;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Tc_06_CreateContactWithOrganizationTest {
	public static void main(String[] args) {

		//		ExcelOperationsUtil excelUtility = new ExcelOperationsUtil();
		//		JavaUtil javaUtility = new JavaUtil();
		//		WebDriverUtil webdriverUtil



		//Initialization of classes
		FileOperationsUtil fileUtility = new FileOperationsUtil();
		JavaUtil javaUtility = new JavaUtil();
		ExcelOperationsUtil excelUtility = new ExcelOperationsUtil();
		WebDriverUtil webdriverUtility = new WebDriverUtil();


		//Initalize data
		fileUtility.intiallizeProperyFile(IConstantUtils.VTIGERPROPERTYFILEPATH);
		excelUtility.initExcelFile(IConstantUtils.VTIGEREXCELPATH);



		//Generate the random number
		int randomNumber = javaUtility.getRandomNumber();

		//Get the Control of particular sheet
		excelUtility.initExcelFile(IConstantUtils.VTIGEREXCELPATH);


		//Fetch the data from property file
		String browser= fileUtility.getDataFromProperty("browser");
		String username= fileUtility.getDataFromProperty("username");
		String password= fileUtility.getDataFromProperty("password");
		String url= fileUtility.getDataFromProperty("url");
		String timeouts= fileUtility.getDataFromProperty("timeout");
		String expectedOrgName=excelUtility.getDataFromExcel(4, 1, "Campaigns")+randomNumber;


		//convertString to Long
		long longTimeOut = javaUtility.convertStringToLong(timeouts);



		//SetBrowser
		WebDriver driver = webdriverUtility.setupDriver(browser);




		//init the wait condition,actions
		webdriverUtility.initActions();

		//navigate the app
		webdriverUtility.maximizeBrowser();
		webdriverUtility.implicitWait(longTimeOut);
		webdriverUtility.initActions();
		webdriverUtility.openApplication(url);




		//		WebDriverManager.chromedriver().setup();
		//		WebDriver driver = new ChromeDriver();

		//driver.get();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(tSec));
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.xpath("//a[@href='index.php?module=Accounts&action=index']")).click();
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		//int randomNum= new Random().nextInt();
		//String org = "TyssIndia"+randomNum;
		driver.findElement(By.xpath("//input[@class='detailedViewTextBox']/parent::td[@class='dvtCellInfo']/input[@name='accountname']")).sendKeys(expectedOrgName);
		driver.findElement(By.xpath("(//input[@class='crmbutton small save'])[1]")).click();

		//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(tSec));
		//		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='dvHeaderText']")));

		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		String expectedLastName=excelUtility.getDataFromExcel(4, 2, "Campaigns")+randomNumber;
		driver.findElement(By.name("lastname")).sendKeys(expectedLastName);
		driver.findElement(By.xpath("//img[@alt='Select']/preceding-sibling::input[@name='account_id']/../img")).click();
		Set<String> tab = driver.getWindowHandles();
		String ptab = driver.getWindowHandle();
		for(String ctab:tab) {

			if(!ptab.equals(ctab))
			{
				driver.switchTo().window(ctab);
				break;
			}
		}
		driver.findElement(By.xpath("//input[@id='search_txt']")).sendKeys(expectedOrgName);
		driver.findElement(By.xpath("//input[@name='search']")).click();
		//driver.findElement(By.xpath("//tr[@class='lvtColData']/td/a[.='"+org+"']")).click();
		driver.findElement(By.xpath("//a[.='"+expectedOrgName+"']")).click();
		driver.switchTo().window(ptab);

		driver.findElement(By.xpath("(//input[@class='crmButton small save'])[1]")).click();
		String actualLastName = driver.findElement(By.xpath("//span[@id='dtlview_Last Name']")).getText();
		//String act = lastName;
		if(expectedLastName.contains(actualLastName))
			System.out.println("VALIDATION PASS");
		else
			System.out.println("VALIDATION FAIL");

		//Actions a = new Actions(driver);


		WebElement admin = driver.findElement(By.xpath("(//img[@style='padding: 0px;padding-left:5px'])[1]"));
		webdriverUtility.mouseHoverOnElement(admin);

		WebElement signout = driver.findElement(By.xpath("//a[text()='Sign Out']"));
		webdriverUtility.mouseHoverOnElementAndClick(signout);

		//a.click().build().perform();
		webdriverUtility.closeBrowser();


	}
}