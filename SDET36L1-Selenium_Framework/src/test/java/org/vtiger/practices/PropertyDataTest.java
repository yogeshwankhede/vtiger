package org.vtiger.practices;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PropertyDataTest {
	public static void main(String[] args) throws IOException {

		FileInputStream fis = new FileInputStream("E:\\Eclipse Workspace\\Selenium Workpace\\SDET36L1-Selenium_Framework\\src\\test\\resources\\data\\commondata.properties");
		Properties p = new Properties();
		p.load(fis);
		WebDriver driver=null;
		
		String url1 = p.getProperty("url").trim();
		String un = p.getProperty("username").trim();
		String pwd = p.getProperty("password").trim();
		String tout = p.getProperty("timeout").trim();
		String browser = p.getProperty("browser").trim();
		long out=Long.parseLong(tout);

		switch ( browser) {
		case "chrome":
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
		}
		case "firefox":
		{
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		}
		case "msedge":
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;
		}

		default:
		{System.out.println("There is a problem with the browser");
		break;}
		}


		FileInputStream fex=new FileInputStream("E:\\Eclipse Workspace\\Selenium Workpace\\SDET36L1-Selenium_Framework\\src\\test\\resources\\data\\product.xlsx");
		Workbook wb = WorkbookFactory.create(fex);

		String data = wb.getSheet("products").getRow(1).getCell(1).getStringCellValue();
		



		driver.get(url1);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(out));
		driver.findElement(By.name("user_name")).sendKeys(un);
		driver.findElement(By.name("user_password")).sendKeys(pwd);
		driver.findElement(By.id("submitButton")).click();

		driver.findElement(By.xpath("//a[@href='index.php?module=Products&action=index']")).click();
		driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
		int randomNumber= new Random().nextInt();
		String product = data+randomNumber;
		driver.findElement(By.xpath("//input[@class='detailedViewTextBox']/parent::td[@class='dvtCellInfo']/input[@name='productname']")).sendKeys(product);
		driver.findElement(By.xpath("(//input[@class='crmbutton small save'])[1]")).click();

		String act = driver.findElement(By.id("dtlview_Product Name")).getText();
		if(act.equals(product))
			System.out.println("TestCase Pass");
		else
			System.out.println("TestCase fail");
		wb.close(); 
		driver.quit();
	}

}
