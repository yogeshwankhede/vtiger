package org.tyss.genricUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.bouncycastle.util.Properties;

/**
 *  class to provide data 
 * @author yogir
 *
 */

public final class ExcelOperationsUtil {
	private Workbook workbook;
	/**
	 *  This method is used to fetch data from excel
	 * @param excelPath
	 * @param sheetName
	 */


	public void initExcelFile(String excelPath) {
		FileInputStream fisExcel=null;
		try {
			fisExcel= new FileInputStream(excelPath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		try {
			workbook=WorkbookFactory.create(fisExcel);
		} catch (EncryptedDocumentException | IOException e) {
			e.printStackTrace();
		}


	}
	/**
	 * This method is used to retrive from property file
	 */
	public String getDataFromProprty(String key) {
		return Properties.getPropertyValue(key);
	}

	/**
	 * This method is used to fetch data from excel
	 * @param rowNumber
	 * @param cellNumber
	 * @param sheetName
	 * @return 
	 */


	public String getDataFromExcel(int rowNumber, int cellNumber, String sheetName) {
		org.apache.poi.ss.usermodel.Sheet sheet = workbook.getSheet(sheetName);
		return new DataFormatter().formatCellValue(sheet.getRow(rowNumber).getCell(cellNumber));
	}


	/**
	 * This Method is to write data to excel
	 */
	public void setDataToExcel() {
		FileOutputStream fos = null ;
		try {
			fos = new FileOutputStream(IConstantUtils.VTIGEREXCELPATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			workbook.write(fos);
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}

	/**
	 * This method is to close connection
	 */

	public void closeWorkbook() {
		try {
			workbook.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}




