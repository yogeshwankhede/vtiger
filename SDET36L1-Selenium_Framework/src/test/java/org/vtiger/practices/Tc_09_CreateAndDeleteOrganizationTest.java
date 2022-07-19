package org.vtiger.practices;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.tyss.genricUtilities.BaseClass;
import org.tyss.genricUtilities.ExcelOperationsUtil;
import org.tyss.genricUtilities.FileOperationsUtil;
import org.tyss.genricUtilities.IConstantUtils;
import org.tyss.genricUtilities.JavaUtil;
import org.tyss.genricUtilities.WebDriverUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tc_09_CreateAndDeleteOrganizationTest extends BaseClass {
	public static void main(String[] args) {
		
		
		
//		
//		//Initialization of classes
//		FileOperationsUtil fileUtility = new FileOperationsUtil();
//		JavaUtil javaUtility = new JavaUtil();
//		ExcelOperationsUtil excelUtility = new ExcelOperationsUtil();
//		WebDriverUtil webdriverUtility = new WebDriverUtil();
//
//
//		//Initalize data
//		fileUtility.intiallizeProperyFile(IConstantUtils.VTIGERPROPERTYFILEPATH);
//		excelUtility.initExcelFile(IConstantUtils.VTIGEREXCELPATH);
//
//
//
//		//Generate the random number
//		int randomNumber = javaUtility.getRandomNumber();
//
//		//Get the Control of particular sheet
//		excelUtility.initExcelFile(IConstantUtils.VTIGEREXCELPATH);
//
//
//		//Fetch the data from property file
//		String browser= fileUtility.getDataFromProperty("browser");
//		String userName= fileUtility.getDataFromProperty("username");
//		String password= fileUtility.getDataFromProperty("password");
//		String url= fileUtility.getDataFromProperty("url");
//		String timeouts= fileUtility.getDataFromProperty("timeout");
//		String expectedOrgName=excelUtility.getDataFromExcel(2, 1, "Organization")+randomNumber;
//
//		//convertString to Long
//		long longTimeOut = javaUtility.convertStringToLong(timeouts);
//
//
//
//		//SetBrowser
//		WebDriver driver = webdriverUtility.setupDriver(browser);
//
//
//
//
//		//init the wait condition,actions
//		webdriverUtility.initActions();
//
//		//navigate the app
//		webdriverUtility.maximizeBrowser();
//		webdriverUtility.implicitWait(longTimeOut);
//		webdriverUtility.initActions();
//		webdriverUtility.openApplication(url);
//		
//		
//		//login
//
//
//		driver.findElement(By.name("user_name")).sendKeys(userName);
//		driver.findElement(By.name("user_password")).sendKeys(password);
//		driver.findElement(By.id("submitButton")).click();
//		
		
		
		
		
//		WebDriverManager.edgedriver().setup();
//		WebDriver driver = new EdgeDriver();
//		driver.get("http://localhost:8888/");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		driver.findElement(By.name("user_name")).sendKeys("admin");
//		driver.findElement(By.name("user_password")).sendKeys("admin");
//		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.xpath("//a[@href='index.php?module=Accounts&action=index']")).click();
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
//		int randomNum= new Random().nextInt();
//		String org = "TyssIndia"+randomNum;
		driver.findElement(By.xpath("//input[@class='detailedViewTextBox']/parent::td[@class='dvtCellInfo']/input[@name='accountname']")).sendKeys("123");
		driver.findElement(By.xpath("(//input[@class='crmbutton small save'])[1]")).click();
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[@class='small']"))));
		//webdriverUtility.waitTillElementVisible("//span[@class='small");
	
		driver.findElement(By.xpath("//a[.='Organizations']//parent::td[@class='moduleName']")).click();
		
		String[] arrpageCount = driver.findElement(By.xpath("//span[@name='Accounts_listViewCountContainerName']")).getText().split("");
		 int pageCount = Integer.parseInt(arrpageCount[arrpageCount.length-1]);
		driver.findElement(By.xpath("//input[@class='small']")).clear();
		driver.findElement(By.xpath("//input[@class='small']")).sendKeys(pageCount+"",Keys.ENTER);
		boolean flag=true;
		for(int j=0; j<pageCount;j++) {
			List<WebElement> listOfOrganization = driver.findElements(By.xpath("//table[@class='lvt small']/tbody/tr/td[3]/a"));
			for(int i=0; i<listOfOrganization.size(); i++) {
				String orgName=listOfOrganization.get(i).getText();
				if("".equals(orgName)) {
				driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr["+(j+2)+"]/td[1]/input")).click();
				flag=false;
				break;
				
			}}
			if(flag==false) {
				break;
		}
			else {
				driver.findElement(By.xpath("//a[@alt='Next']")).click();
				//wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.id("status"))));
	
			}}
		
				driver.close();
		
		
		

	}

}
