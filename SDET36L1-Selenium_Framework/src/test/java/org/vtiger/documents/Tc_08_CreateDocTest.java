//package org.vtiger.documents;
//
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.util.Properties;
//import java.util.Random;
//
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.ss.usermodel.WorkbookFactory;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//import io.github.bonigarcia.wdm.WebDriverManager;

//public class Tc_08_CreateDocTest {
//	public static void main(String[] args) throws IOException {
//		
////	
//////	//initalize data from property file
//////	FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\data\\commondata.properties");
//////	Properties properties = new Properties();
//////	properties.load(fis);
//////	
//////	//generate random number
//////	int randomNumber = new Random().nextInt(1000);
//////	
//////	//get the control for particular sheet in excel
//////	FileInputStream fisExcel = new FileInputStream("");
//////	Workbook workbook = WorkbookFactory.create(fisExcel);
//////	Sheet sheet = workbook.getSheet("Documents");
//////	
//////	//fetch the data from property file
//////	String browser = properties.getProperty("browser").trim();
//////	String userName = properties.getProperty("username").trim();
//////	String password = properties.getProperty("password").trim();
//////	String url = properties.getProperty("url").trim();
//////	String timeouts = properties.getProperty("timeout").trim();
//////	
//////	//fetch the data from excel file
//////	String expectedDocumentType = sheet.getRow(2).getCell(1).getStringCellValue()+randomNumber;
//////	String expectedDescripton = sheet.getRow(2).getCell(2).getStringCellValue();
//////	String filepath = sheet.getRow(2).getCell(3).getStringCellValue();
////	
////	//convert String into long
////	long longTimeout = Long.parseLong(timeouts);
////	
////	//launching the browser in run time based on browser key
////	WebDriver driver=null;
////	//run time polymorphism
////	switch (browser) {
////	case "chrome":
////		WebDriverManager.chromedriver().setup();
////		driver=new ChromeDriver();
////		
////		
////		
////		break;
////
////	default:
////		break;
////	}
////	
////	
////	
////	}
//}
