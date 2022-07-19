//package org.vtiger.practices;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//import com.mysql.cj.jdbc.Driver;
//
//public class Db_Practice1 extends ExcelInputDb {
//	public static void main(String[] args) throws SQLException {
//		
//		
//		//create the obj for class
//		Driver driver = new Driver();
//		
//		
//		//register
//		DriverManager.registerDriver(driver);
//		
//		//establish connection
//		Connection connection = DriverManager.getConnection("//localhost:3306/tyss","root", "root");
//		
//		//create statement
//		Statement statement = connection.createStatement();
//		statement.executeUpdate("insert into companies values("ExcelInputDb.data");");
//		
//		connection.close();
//		
//	}
//
//}
