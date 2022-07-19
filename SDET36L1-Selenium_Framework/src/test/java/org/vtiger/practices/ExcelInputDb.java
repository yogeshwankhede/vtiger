//package org.vtiger.practices;
//
//import java.io.FileInputStream;
//import java.io.IOException;
//
//import org.apache.poi.EncryptedDocumentException;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.ss.usermodel.WorkbookFactory;
//
//public class ExcelInputDb {
//	public static String getData(int r, int c) throws EncryptedDocumentException, IOException {
//		
//	
//	
//
//	public static void data(int r int c) {
//		FileInputStream fis = new FileInputStream("E:\\Eclipse Workspace\\Selenium Workpace\\SDET36L1-Selenium_Framework\\src\\test\\resources\\data\\Book.xlsx");
//		Workbook wb = WorkbookFactory.create(fis);
//		 String data = wb.getSheet("Sheet1").getRow(r).getCell(c).getStringCellValue();
//		return data;
//		}		
//	}
//}
