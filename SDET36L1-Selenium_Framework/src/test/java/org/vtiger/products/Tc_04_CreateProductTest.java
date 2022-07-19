package org.vtiger.products;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Tc_04_CreateProductTest {
	public static void main(String[] args) {
		WebDriverManager.edgedriver().setup();
		WebDriver driver = new EdgeDriver();
		driver.get("http://localhost:8888/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.xpath("//a[@href='index.php?module=Products&action=index']")).click();
		driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
		String product = "flinko";
		driver.findElement(By.xpath("//input[@class='detailedViewTextBox']/parent::td[@class='dvtCellInfo']/input[@name='productname']")).sendKeys(product);
		driver.findElement(By.xpath("(//input[@class='crmbutton small save'])[1]")).click();
		
		String act = driver.findElement(By.id("dtlview_Product Name")).getText();
		if(act.equals(product))
			System.out.println("TestCase Pass");
		else
			System.out.println("TestCase fail");
		driver.quit();
	}
}
