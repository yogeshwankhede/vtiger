package org.vtiger.practices;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * This Class is to remove broken links from webpage
 * 
 * @author Yogesh W.
 *
 */

public class BrokenLinks002 {
	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		List<WebElement> allLinks = driver.findElements(By.xpath("//a"));
		// int count = allLinks.size();
		for (WebElement links : allLinks) {
			String linkUrl = links.getAttribute("href");
			// create Url instance
			URL url = null;
			url = new URL(linkUrl);
			// Open object connection
			URLConnection urlConnection = null;
			urlConnection = url.openConnection();
			// Establish Http connection ,set timeout and connect
			HttpURLConnection httpURLConnection = (HttpURLConnection) urlConnection;
			httpURLConnection.setConnectTimeout(5000);
			httpURLConnection.connect();

			if (httpURLConnection.getResponseCode() == 200)

				System.out.println(linkUrl + "_" + httpURLConnection.getResponseCode());

		}

	}

}
