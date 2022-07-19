package org.vtiger.contacts;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.tyss.genricUtilities.ExcelOperationsUtil;
import org.tyss.genricUtilities.FileOperationsUtil;
import org.tyss.genricUtilities.IConstantUtils;
import org.tyss.genricUtilities.JavaUtil;
import org.tyss.genricUtilities.WebDriverUtil;
import org.vtiger.practices.UtilityBase;

import io.github.bonigarcia.wdm.WebDriverManager;


public class CreateContactTest extends UtilityBase {
	public static void main(String[] args) throws InterruptedException {
//		WebDriverManager.chromedriver().setup();
//		WebDriver driver = new ChromeDriver();
//		driver.get("http://localhost:8888/");
	

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
		String userName= fileUtility.getDataFromProperty("username");
		String password= fileUtility.getDataFromProperty("password");
		String url= fileUtility.getDataFromProperty("url");
		String timeouts= fileUtility.getDataFromProperty("timeout");
		String expectedContLastname=excelUtility.getDataFromExcel(2, 1, "Contact")+randomNumber;


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

		
		driver.findElement(By.name("user_name")).sendKeys(userName);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
		driver.findElement(By.name("lastname")).sendKeys("Wankhede");
		driver.findElement(By.xpath("//input[@class='crmButton small save']")).click();
		String actualContLastName = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		//String act = "Wankhede";
		if(expectedContLastname.contains(actualContLastName))
			System.out.println("VALIDATION PASS");
		else
			System.out.println("VALIDATION FAIL");
		
		//Actions a = new Actions(driver);
		//user fn+f8 to pause the screen while mouse hover action 
		
		WebElement admin = driver.findElement(By.xpath("(//img[@style='padding: 0px;padding-left:5px'])[1]"));
		//a.moveToElement(admin);
		webdriverUtility.mouseHoverOnElement(admin);
		WebElement signout = driver.findElement(By.xpath("//a[text()='Sign Out']"));
		//a.moveToElement(signout);
		webdriverUtility.mouseHoverOnElementAndClick(signout);
		//a.click().build().perform();
		webdriverUtility.closeBrowser();
		//driver.quit(); 
		
		
		
	}
}
