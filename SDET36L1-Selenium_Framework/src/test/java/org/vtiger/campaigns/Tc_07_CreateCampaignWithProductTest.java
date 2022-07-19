
package org.vtiger.campaigns;

import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.tyss.genricUtilities.ExcelOperationsUtil;
import org.tyss.genricUtilities.FileOperationsUtil;
import org.tyss.genricUtilities.IConstantUtils;
import org.tyss.genricUtilities.JavaUtil;
import org.tyss.genricUtilities.WebDriverUtil;

public class Tc_07_CreateCampaignWithProductTest {
	public static void main(String[] args)  {
		//
		//		WebDriverManager.edgedriver().setup();
		//		WebDriver driver = new EdgeDriver();
		//  

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
		String expectedCampName=excelUtility.getDataFromExcel(2, 1, "Campaigns")+randomNumber;


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




		//		driver.get("http://localhost:8888/");
		//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
		//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.name("user_name")).sendKeys(userName);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();

		driver.findElement(By.xpath("//a[@href='index.php?module=Products&action=index']")).click();
		driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
		int randomNum=new Random().nextInt(1000);
		String product = "flinko"+randomNum;
		driver.findElement(By.xpath("//input[@class='detailedViewTextBox']/parent::td[@class='dvtCellInfo']/input[@name='productname']")).sendKeys(product);
		driver.findElement(By.xpath("(//input[@class='crmbutton small save'])[1]")).click();

		//	WebDriverWait wait = new WebDriverWait(driver, 10);
		//	wait.unt il(ExpectedConditions.visibi("Product Information"));
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		Actions a = new Actions(driver);

		WebElement more = driver.findElement(By.xpath("//a[text()='More']"));
		WebElement campgn = driver.findElement(By.xpath("//a[@name='Campaigns']"));
		a.moveToElement(more);
		a.moveToElement(campgn);

		a.click().build().perform();

		driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();

		driver.findElement(By.xpath("//input[@name='campaignname']")).sendKeys(expectedCampName);
		driver.findElement(By.xpath("//img[@alt='Select']")).click();
		Set<String> tab = driver.getWindowHandles();
		String ptab = driver.getWindowHandle();
		for(String ctab:tab) {

			if(!ptab.equals(ctab))
			{
				driver.switchTo().window(ctab);
				break;
			}
		}
		driver.findElement(By.xpath("//input[@name='search_text']")).sendKeys(product);
		driver.findElement(By.xpath("//td[@class='dvtCellLabel']/child::input[@name='search']")).click();
		driver.findElement(By.xpath("//a[.='"+product+"']")).click();

		driver.switchTo().window(ptab);
		driver.findElement(By.xpath("//input[@class='crmButton small save']")).click();
		String actualCampName = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(actualCampName.contains(expectedCampName)) 
			System.out.println("Validation Pass");
		else
			System.out.println("Validation fail");
		WebElement admin = driver.findElement(By.xpath("(//img[@style='padding: 0px;padding-left:5px'])[1]"));
		WebElement signout = driver.findElement(By.xpath("//a[text()='Sign Out']"));
		a.moveToElement(admin).perform();
		signout.click();

		driver.quit();




	}

}
