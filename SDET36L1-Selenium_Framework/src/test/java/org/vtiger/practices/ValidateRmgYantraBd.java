package org.vtiger.practices;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.cj.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ValidateRmgYantraBd {
	public static void main(String[] args) throws SQLException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8084/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[.='Sign in']")).click();
		driver.findElement(By.xpath("//a[.='Projects']")).click();
		driver.findElement(By.xpath("//button[@class='btn btn-success']")).click();
		int randomNumber = new Random().nextInt(100);
		String expectedProjectName   = "Sdet36"+randomNumber;
		driver.findElement(By.xpath("//input[@name='projectName']")).sendKeys(expectedProjectName);
		driver.findElement(By.xpath("//input[@name='createdBy']")).sendKeys("Mohan sir");

		WebElement dropdowns = driver.findElement(By.xpath("//label[.='Project Status ']/following-sibling::select"));
		Select select = new Select(dropdowns);
		select.selectByValue("On Going");
		driver.findElement(By.xpath("//input[@value='Add Project']")).click();


		Driver driver1 = new Driver();


		DriverManager.registerDriver(driver1);

		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root", "root");

		Statement statement = connection.createStatement();
		ResultSet projects = statement.executeQuery("select * from project;");	

		while(projects.next()) 
		{
			Object out = projects.getString("project_name");

			if(out.equals(expectedProjectName)) 
				System.out.println("project is created");
			else 
				System.out.println("Project is not created");
			}
		driver.quit();

	}

}


  