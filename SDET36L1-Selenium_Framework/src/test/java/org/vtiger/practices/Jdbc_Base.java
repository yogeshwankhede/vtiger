package org.vtiger.practices;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import com.mysql.cj.jdbc.Driver;

public class Jdbc_Base {
	public static String url,un,pwd,randomTitle,descr;
	public static int tSec,mSec;
	public static void data()  {
		Driver driver1 = null;
		try {
			driver1 = new Driver();
		} catch (SQLException e4) {
			// TODO Auto-generated catch block
			e4.printStackTrace();
		}


		try {
			DriverManager.registerDriver(driver1);
		} catch (SQLException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}

		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tyss","root", "root");
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		Statement statement = null;
		try {
			statement = connection.createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		ResultSet projects = null;
		try {
			projects = statement.executeQuery("select * from login;");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			while(projects.next()) {
			  url = projects.getString("url");
			  un = projects.getString("userName");
			  pwd = projects.getString("password");
			  int r = new Random().nextInt(100);
				 randomTitle = "ieepaper"+r;
				 tSec=projects.getInt("time_in_sec");
				 mSec=projects.getInt("time_in_msec");
			//System.out.println(url+" "+" "+un+" "+pwd+" "+tSec+" "+mSec);
				 descr="This is demo description for document page";
			
}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

			}

}
