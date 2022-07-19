package org.vtiger.organizations;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tc_09_CreateDeleteOrganization {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\data\\commondata.properties");
		Properties properties = new Properties();
		properties.load(fis);
		int randomNumber= new Random().nextInt(1000);
		FileInputStream fisExcel=new FileInputStream(".\\src\\test\\resources\\data\\Book.xlsx");
		Workbook workbook=WorkbookFactory.create(fisExcel);
		//String ExpectedContactLastName = workbook.getSheet("company").getRow(2).getCell(1).getStringCellValue()+randomNumber;


		String browser= properties.getProperty("browser").trim();
		String userName= properties.getProperty("username").trim();
		String password= properties.getProperty("password").trim();
		String url= properties.getProperty("url").trim();
		String timeouts= properties.getProperty("timeout").trim();
		long longTimeOut=Long.parseLong(timeouts);

		
		//System.out.println(ExpectedContactLastName);

		WebDriver driver=null;
		//run time polymorphism
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
			break;
		}

//
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(longTimeOut));
//		driver.get(url);
//		driver.findElement(By.name("user_name")).sendKeys(userName);
//		driver.findElement(By.name("user_password")).sendKeys(password);
//		driver.findElement(By.id("submitButton")).click();
//	
		

		driver.findElement(By.xpath("//a[@href='index.php?module=Accounts&action=index']")).click();
		driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		int randomNum= new Random().nextInt();
		String org = "TyssIndia"+randomNum;
		driver.findElement(By.xpath("//input[@class='detailedViewTextBox']/parent::td[@class='dvtCellInfo']/input[@name='accountname']")).sendKeys(org);
		driver.findElement(By.xpath("(//input[@class='crmbutton small save'])[1]")).click();
		}

}
