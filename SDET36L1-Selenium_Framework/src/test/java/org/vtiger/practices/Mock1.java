//package org.vtiger.practices;
//
//public class Mock1 {
//}
//
//	class Tc01_ReadExcelTest{
//		public static void main(String[]args){
//		FileInputStream fis = new FileInputStream("./scr/test/resources/demo.xlsx");
//		Workbook wb = WorkBookFactory.create(fis);                               // check this lines
//
//		String data= wb.getSheet("documents").getRow(2).getcell(2).getStringCellValue();
//		System.out.print("Excel readOut is "+data);
//		wb.close();
//		}
//		}
//	class Tc_02_WriteDataInEXcel{
//		public static void main(String[]args){
//		FileInputStream fis = new FileInputStream("./scr/test/resources/demo.xlsx");
//		Workbook wb = new WorkBookFactory.crteate(fis);
//		Sheet sheet=wb.getSheet("documents");
//		Row row = sheet.getRow(2);
//		//createcell value is missing
//		row.set
//
//		                                                                            cell.setcellvalue also missing
//		FileOutputStream fos = new FileOutputStram("./scr/test/resources/demo.xlsx");
//		wb.write();
//		wb.close();
//		  }
//		}
//
//
//}
