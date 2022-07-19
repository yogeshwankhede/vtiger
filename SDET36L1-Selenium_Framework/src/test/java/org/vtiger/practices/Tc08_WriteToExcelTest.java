package org.vtiger.practices;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class Tc08_WriteToExcelTest {
	public static void main(String[] args) {
		FileInputStream fis = null;
		Workbook wb = null;
		try {
			fis = new FileInputStream("./src/test/resources/data/product.xlsx");
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
   
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		}
		Sheet sheet = wb.getSheet("products");
		Row row = sheet.getRow(2);
		Cell cell = row.createCell(5);
		cell.setCellValue("230000");

		try {
			FileOutputStream fos = new FileOutputStream("./src/test/resources/data/product.xlsx");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		OutputStream fos = null;
		try {
			wb.write(fos);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Data Entered");
		try {
			wb.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
