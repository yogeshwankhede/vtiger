//package org.vtiger.practices;
//
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Test;
///**
// * This is simple array data provider class
// * @author yogir
// *
// */
//public class TestNGDataProvider {
//	@Test(dataProvider = "dataProvider")
//	public void loginTest(String userName) {
//		System.out.println(userName);
//	}
//	@DataProvider(parallel = true,name = "dataProvider")
//	public Object[] getData() {
//		Object[] objArr=new Object[3];
//		objArr[0]= "ABC";
//		objArr[1]="XYZ";
//		objArr[2]="PQR";
//		return objArr;
//	}
//
//}
