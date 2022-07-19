//package org.vtiger.practices;
//
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Test;
//
//public class TestNGDataProvider2D {
//	@Test(dataProvider = "dataprovider")
//	public void loginTest(String userName, String password) {
//		System.out.println(userName+" "+password);
//	}
//	@DataProvider(parallel = true,name = "dataprovider")
//	public Object[][] getData() {
//		Object[][] objArr= new Object[3][2];
//		objArr[0][0]="ABC";
//		objArr[0][1]=123;
//		objArr[1][0]="PQR";
//		objArr[1][1]=456;
//		objArr[2][0]="KLM";
//		objArr[2][1]=789;
//
//
//		return objArr;
//	}
//}
