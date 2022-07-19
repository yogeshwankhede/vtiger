package org.tyss.genricUtilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseClass {
	FileOperationsUtil fileUtility;
	JavaUtil javaUtility;
	protected static ExcelOperationsUtil excelUtility ;
	WebDriverUtil webdriverUtility;
	protected static int randomNumber;
	long longTimeOut;
	protected static WebDriver driver;
	String browser,userName,password,url,timeouts;
	public String expectedCampName;
	@BeforeSuite
	public void initClasses() {
		//Initialization of classes
		 fileUtility = new FileOperationsUtil();
		 javaUtility = new JavaUtil();
		 excelUtility = new ExcelOperationsUtil();
		 webdriverUtility = new WebDriverUtil();
		 
		 
		//Initalize data
		fileUtility.intiallizeProperyFile(IConstantUtils.VTIGERPROPERTYFILEPATH);
		excelUtility.initExcelFile(IConstantUtils.VTIGEREXCELPATH);



		//Generate the random number
		randomNumber = javaUtility.getRandomNumber();
		//convertString to Long
		 longTimeOut = javaUtility.convertStringToLong(timeouts);

			//SetBrowser
			driver = webdriverUtility.setupDriver(browser);


		//Get the Control of particular sheet
		excelUtility.initExcelFile(IConstantUtils.VTIGEREXCELPATH);
	}
	@BeforeMethod
		public void initAll() {

			//init the wait condition,actions
			webdriverUtility.initActions();
			//navigate the app
			webdriverUtility.maximizeBrowser();
			webdriverUtility.implicitWait(longTimeOut);
			webdriverUtility.initActions();
			webdriverUtility.openApplication(url);

		}
	

	
@BeforeClass
public void fetchData() {
	//Fetch the data from property file
		 browser= fileUtility.getDataFromProperty("browser");
		 userName= fileUtility.getDataFromProperty("username");
		 password= fileUtility.getDataFromProperty("password");
		 url= fileUtility.getDataFromProperty("url");
		 timeouts= fileUtility.getDataFromProperty("timeout");
		 expectedCampName=excelUtility.getDataFromExcel(2, 1, "Campaigns")+randomNumber;
	
}
@BeforeMethod
public void login() {
	//login to the app		
		driver.findElement(By.name("user_name")).sendKeys(userName);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();

}
	


	







	




	
}
