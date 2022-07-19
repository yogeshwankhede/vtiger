package org.vtiger.practices;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Tc007_ExcelDataUpdate {
	public static void main(String[] args) {
		
		FileInputStream fis = null;
		Workbook wb=null;
		try {
			fis = new FileInputStream(".\\src\\test\\resources\\data\\product.xlsx");
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			wb = WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Sheet sheet = wb.getSheet("products");
		for(int i =0;i<= sheet.getLastRowNum();i++) {
				String data = wb.getSheet("products").getRow(i).getCell(1).getStringCellValue();
			System.out.println(data);	
	
		}
		//2D Array data handling
		
		DataFormatter dataformat = new DataFormatter();
		int rowNum = sheet.getLastRowNum();
		int cellNum = sheet.getRow(0).getLastCellNum();
		String [][] str=new String[rowNum][cellNum];
		for(int i=1;i<=rowNum;i++) {
			for(int j=0;j<cellNum;j++) {
				str[i-1][j]=dataformat.formatCellValue(sheet.getRow(i).getCell(j));
			}
		}
		System.out.println(str[2][3]);
		try {
			wb.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
