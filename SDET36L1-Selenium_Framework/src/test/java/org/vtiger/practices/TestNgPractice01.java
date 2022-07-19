//package org.vtiger.practices;
//
//import org.testng.Reporter;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.AfterGroups;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.AfterSuite;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.BeforeGroups;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.BeforeSuite;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Test;
//
//public class TestNgPractice01 {
//	@BeforeSuite
//	public void suiteTry() {
//		System.out.println("here im doing before suite actions ");
//		Reporter.log(" start");
//	}
//	@BeforeTest
//	public void testTry() {
//		System.out.println("here im doing before Tests actions ");
//	}
//	@BeforeClass
//	public void classtry() {
//		System.out.println("here i'm doing before class actions");
//	}
//
//	@BeforeGroups
//	public void groupTry() {
//		System.out.println("here i'm doing before group actions");
//	}
//
//	@BeforeMethod
//	public void methodtry() {
//		System.out.println("here i'm doing before method actions");
//	}
//
//	@Test
//	public void firstAction() {
//		System.out.println("here i'm doing actual first testScript ");
//	}
//
//	@Test(priority = 4)
//	public void RandomAction() {
//		System.out.println("here i'm doing 2nd prioritized testScript ");
//	}@Test(priority = 3)
//	public void RAction() {
//		System.out.println("here i'm doing 1st prioritized testScript ");
//
//	}
//	@Test
//	public void laststAction() {
//		System.out.println("here i'm doing last testScript ");
//	}
//
//	@AfterSuite
//	public void aftersuiteTry() {
//		System.out.println("here im doing After suite actions ");
//	}
//	@AfterTest
//	public void atestTry() {
//		System.out.println("here im doing After Tests actions ");
//	}
//	@AfterClass
//	public void aclasstry() {
//		System.out.println("here i'm doing After class actions");
//	}
//
//	@AfterGroups
//	public void agroupTry() {
//		System.out.println("here i'm doing After group actions");
//	}
//
//	@AfterMethod
//	public void amethodtry() {
//		System.out.println("here i'm doing After method actions");
//	}
//
//
//
//
//}
