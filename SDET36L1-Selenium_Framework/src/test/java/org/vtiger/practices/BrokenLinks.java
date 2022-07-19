package org.vtiger.practices;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinks {
		
	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://www.hyrtutorials.com/p/calendar-practice.html");
		   List<WebElement> allLinks = driver.findElements(By.xpath("//a"));
		List<String> list=new ArrayList<>();
		for(WebElement link:allLinks) {
			String linkString=link.getAttribute("href");
			list.add(linkString);
			list.remove(null);
		}
		for(String url:list) {
			System.out.println(url);
			URL url1=new URL(url);
			URLConnection urlConnection = url1.openConnection();

			
			HttpsURLConnection response= (HttpsURLConnection) urlConnection;
			int statusCode=response.getResponseCode();
			if(statusCode!=200) {
				System.out.println(url1+" ==>"+statusCode+" ==>"+response.getResponseMessage());
			}
		}
	}
}
