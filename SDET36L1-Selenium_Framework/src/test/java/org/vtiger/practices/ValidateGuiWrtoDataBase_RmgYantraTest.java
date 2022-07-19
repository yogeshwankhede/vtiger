package org.vtiger.practices;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.cj.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ValidateGuiWrtoDataBase_RmgYantraTest {
	public static void main(String[] args) throws SQLException, InterruptedException {
		Connection connection=null;
		WebDriver driver=null;
		try {
			FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\data\\commondata.properties");
			Properties properties = new Properties();
			properties.load(fis);

			String url=properties.getProperty("rmgyantraurl");
			String browser=properties.getProperty("browser").trim();
			String username=properties.getProperty("username").trim();
			String password=properties.getProperty("password").trim();
			String timeouts=properties.getProperty("timeout").trim();
			long LongTimeouts=Long.parseLong(timeouts);

			switch (browser) {

			case "chrome":
			{
				WebDriverManager.chromedriver().setup();
				driver=new ChromeDriver();
				break;
			}
			case "firefox":
			{
				WebDriverManager.firefoxdriver().setup();
				driver=new FirefoxDriver();
				break;
			}
			case "Internet Explorer":
			{
				WebDriverManager.edgedriver().setup();
				driver=new EdgeDriver();
				break;
			}
			default:
			{
				System.out.println("case not matched");
			}
			}
			System.out.println("Browser for launch");
			driver.get(url);
			
			Random ran=new Random();
			int randomNumber=ran.nextInt(100);

			String projectName="SDET36"+randomNumber;
			System.out.println("Project Name ==>"+projectName);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.findElement(By.xpath("//input[@id='usernmae']")).sendKeys("rmgyantra");
			driver.findElement(By.xpath("//input[@id='inputPassword']")).sendKeys("rmgy@9999");
			driver.findElement(By.xpath("//button[text()='Sign in']")).click();
			System.out.println("Successfully login");
			driver.findElement(By.xpath("//a[text()='Projects']")).click();
			driver.findElement(By.xpath("//span[text()='Create Project']")).click();
			driver.findElement(By.xpath("//input[@name='projectName']"));

			driver.findElement(By.xpath("//input[@name='projectName']")).sendKeys(projectName);

			driver.findElement(By.xpath("//input[@name='createdBy']")).sendKeys("user1");
			WebElement projectStatus=driver.findElement(By.xpath("//label[.='Project Status ']/following-sibling::select"));
			Select select=new Select(projectStatus);
			select.selectByVisibleText("On Goging");
			driver.findElement(By.xpath("//input[@class='btn btn-success']")).click();
			System.out.println("successfully project created");
			Thread.sleep(10);

			Driver dbDriver=new Driver();
			DriverManager.registerDriver(dbDriver);
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
			java.sql.Statement statement=connection.createStatement();
			ResultSet result=statement.executeQuery("select * from project;");

			while(result.next())
			{
				if(result.getString("project_name").equals(projectName))
				{
					System.out.println("data is present in database");
					System.out.println("Actual project Name==>"+result.getString("project_name"));
				}

			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}


}
