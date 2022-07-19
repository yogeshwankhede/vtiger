//package org.vtiger.organizations;
//
//import java.time.Duration;
//import java.util.Random;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.support.ui.Select;
//import org.tyss.genricUtilities.ExcelOperationsUtil;
//import org.tyss.genricUtilities.FileOperationsUtil;
//import org.tyss.genricUtilities.IConstantUtils;
//import org.tyss.genricUtilities.JavaUtil;
//import org.tyss.genricUtilities.WebDriverUtil;
//import org.vtiger.practices.Jdbc_Base;
//
//import io.github.bonigarcia.wdm.WebDriverManager;
//
//public class Tc_05_CreateOrganizationWithIndustryAndTypeTest extends Jdbc_Base {
////	public static void main(String[] args) {
//// 
//////		WebDriverManager.edgedriver().setup();
//////		WebDriver driver = new EdgeDriver();
//////		driver.get("http://localhost:8888/");
////	   //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
////		
////		
////		
////		//Initialization of classes
////				FileOperationsUtil fileUtility = new FileOperationsUtil();
////				JavaUtil javaUtility = new JavaUtil();
////				ExcelOperationsUtil excelUtility = new ExcelOperationsUtil();
////				WebDriverUtil webdriverUtility = new WebDriverUtil();
////
////
////				//Initalize data
////				fileUtility.intiallizeProperyFile(IConstantUtils.VTIGERPROPERTYFILEPATH);
////				excelUtility.initExcelFile(IConstantUtils.VTIGEREXCELPATH);
////
////
////
////				//Generate the random number
////				int randomNumber = javaUtility.getRandomNumber();
////
////				//Get the Control of particular sheet
////				excelUtility.initExcelFile(IConstantUtils.VTIGEREXCELPATH);
////
////
////				//Fetch the data from property file
////				String browser= fileUtility.getDataFromProperty("browser");
////				String userName= fileUtility.getDataFromProperty("username");
////				String password= fileUtility.getDataFromProperty("password");
////				String url= fileUtility.getDataFromProperty("url");
////				String timeouts= fileUtility.getDataFromProperty("timeout");
////				String expectedOrgName=excelUtility.getDataFromExcel(2, 2, "Organization")+randomNumber;
////
////
////				//convertString to Long
////				long longTimeOut = javaUtility.convertStringToLong(timeouts);
////
////
////
////				//SetBrowser
////				WebDriver driver = webdriverUtility.setupDriver(browser);
////
////
////
////
////				//init the wait condition,actions
////				webdriverUtility.initActions();
////
////				//navigate the app
////				webdriverUtility.maximizeBrowser();
////				webdriverUtility.implicitWait(longTimeOut);
////				webdriverUtility.initActions();
////				webdriverUtility.openApplication(url);
////		
////		driver.findElement(By.name("user_name")).sendKeys(userName);
////		driver.findElement(By.name("user_password")).sendKeys(password);
////		driver.findElement(By.id("submitButton")).click();
//		
//		driver.findElement(By.xpath("//a[@href='index.php?module=Accounts&action=index']")).click();
//		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
////		int randomNumber = new Random().nextInt(100);
////		String org = "TyssIndia"+randomNumber;
//		driver.findElement(By.xpath("//input[@class='detailedViewTextBox']/parent::td[@class='dvtCellInfo']/input[@name='accountname']")).sendKeys(expectedOrgName);
//		WebElement industryDropDown = driver.findElement(By.xpath("//td[@class='dvtCellInfo']/select[@name='industry']"));
//		Select selct = new Select(industryDropDown);
//		selct.selectByValue("Education");
//		WebElement typeDropDown = driver.findElement(By.xpath("//td[@class='dvtCellInfo']/select[@name='accounttype']"));
//		Select slct= new Select(typeDropDown);
//		slct.selectByValue("Press");
//		driver.findElement(By.xpath("//input[@type='radio']/../../td/input[2]")).click();
//		driver.findElement(By.xpath("(//input[@class='crmbutton small save'])[1]")).click();
//		
//		String actualOrgName = driver.findElement(By.id("dtlview_Organization Name")).getText();
//		if(actualOrgName.equals(expectedOrgName))
//			System.out.println("TestCase Pass");
//		else
//			System.out.println("TestCase fail");
//		driver.quit();
//	
//		
//	}
//
//}
