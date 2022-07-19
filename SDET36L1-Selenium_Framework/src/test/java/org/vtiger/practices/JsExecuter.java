package org.vtiger.practices;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.tyss.genricUtilities.JavaUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JsExecuter {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		JavaUtil javaUtility = new JavaUtil();
		JsExecuter currentClass = new JsExecuter();
		
		
	   JavascriptExecutor js = (JavascriptExecutor) driver;
	   js.executeScript("window.location='http://localhost:8888/'");
	    WebElement userNameTxtField = driver.findElement(By.name("user_name"));
	    WebElement passwordTextField = driver.findElement(By.name("user_password"));
	    WebElement loginButton = driver.findElement(By.id("submitButton"));
	    js.executeScript("arguments[0].value=arguments[1]",userNameTxtField,"admin");
	    js.executeScript("arguments[0].value=arguments[1]",passwordTextField,"admin");
	    js.executeScript("arguments[0].click()",loginButton);
		
	}

}
