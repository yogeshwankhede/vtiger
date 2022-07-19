package org.vtiger.documents;

 import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.tyss.genricUtilities.ExcelOperationsUtil;
import org.tyss.genricUtilities.FileOperationsUtil;
import org.tyss.genricUtilities.IConstantUtils;
import org.tyss.genricUtilities.JavaUtil;
import org.tyss.genricUtilities.WebDriverUtil;
import org.vtiger.practices.Jdbc_Base;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tc_08_CreateDocumentTest {
	//public static WebDriver driver;
	public static void main(String[] args) {
//		WebDriverManager.chromedriver().setup();
//	   driver = new ChromeDriver();
//		Jdbc_Base.data();
		
		
		
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
		String expectedTitle=excelUtility.getDataFromExcel(1, 1, "Document")+randomNumber;
		String descrpt=excelUtility.getDataFromExcel(2, 1, "Document");


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



		
		
		
//		driver.get(url);
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.manage().window().maximize();
		driver.findElement(By.name("user_name")).sendKeys(userName);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.xpath("//a[normalize-space()='Documents']")).click();
		driver.findElement(By.xpath("//img[@title='Create Document...']")).click();
		driver.findElement(By.xpath("//input[@name='notes_title']")).sendKeys(expectedTitle);
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//html[@dir='ltr']/child::body[@class='cke_show_borders']")).sendKeys(descrpt);
		driver.switchTo().defaultContent();
	
		
		driver.findElement(By.xpath("//input[@id='filename_I__']")).sendKeys("C:\\Users\\yogir\\OneDrive\\Documents\\AdHoc Senario 01.docx");
		driver.findElement(By.xpath("//body[1]/table[4]/tbody[1]/tr[1]/td[2]/div[1]/form[1]/table[1]/tbody[1]/tr[2]/td[1]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[2]/td[1]/table[1]/tbody[1]/tr[13]/td[1]/div[1]/input[1]")).click();
		
		
		//exp=driver.findElement(By.xpath("//span[@id='dtlview_Title']")).g
		//driver.findElement(By.xpath("//input[@class='crmButton small save']")).click();
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait1.until(ExpectedConditions.presenceOfElementLocated(By.id("dtlview_Title")));
		String actualTitle = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(actualTitle.contains(expectedTitle)) 
			System.out.println("Validation Pass");
		else
			System.out.println("Validation fail");
		Actions a = new Actions(driver);
		//driver.findElement(By.xpath("//input[@class='crmButton small save']")).click();
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		wait.until(ExpectedConditions.visibilityOf((WebElement) By.xpath("//span[@class='small']")));
		WebElement admin = driver.findElement(By.xpath("(//img[@style='padding: 0px;padding-left:5px'])[1]"));
		WebElement signout = driver.findElement(By.xpath("//a[text()='Sign Out']"));
		a.moveToElement(admin).perform();
		signout.click();
		
		driver.quit();
	
	}

}
