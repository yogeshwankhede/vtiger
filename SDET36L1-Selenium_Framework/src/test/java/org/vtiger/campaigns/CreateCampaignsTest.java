package org.vtiger.campaigns;
 import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.tyss.genricUtilities.ExcelOperationsUtil;
import org.tyss.genricUtilities.FileOperationsUtil;
import org.tyss.genricUtilities.IConstantUtils;
import org.tyss.genricUtilities.JavaUtil;
import org.tyss.genricUtilities.WebDriverUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateCampaignsTest  {

	public static void main(String[] args)   {
//		WebDriverManager.chromedriver().setup();
//		WebDriver driver = new ChromeDriver();
//		
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
		String expectedCampName=excelUtility.getDataFromExcel(2, 1, "Campaigns")+randomNumber;


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



		
		
		//login to the app		
		driver.findElement(By.name("user_name")).sendKeys(userName);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		
		
		WebElement more = driver.findElement(By.xpath("//a[text()='More']"));
		webdriverUtility.mouseHoverOnElement(more);
		WebElement campgn = driver.findElement(By.xpath("//a[@name='Campaigns']"));
		webdriverUtility.mouseHoverOnElement(campgn);
		
		driver.findElement(By.xpath("//a[.='Campaigns']")).click();
		driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
		
		driver.findElement(By.xpath("//input[@name='campaignname']")).sendKeys(expectedCampName);
		
		driver.findElement(By.xpath("//input[@class='crmButton small save']")).click();
		
		
		String actualCampName = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(actualCampName.contains(expectedCampName)) 
			System.out.println("Validation Pass");
		else
			System.out.println("Validation fail");
		WebElement admin = driver.findElement(By.xpath("(//img[@style='padding: 0px;padding-left:5px'])[1]"));
		WebElement signout = driver.findElement(By.xpath("//a[text()='Sign Out']"));
		webdriverUtility.mouseHoverOnElement(admin);
		signout.click();
		
		driver.quit();
		}

}
