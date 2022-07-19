package org.vtiger.practices;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class PropertyCommonData {
	public static String url1;
	public static String un;
	public static String pwd;
	public static String tout;
	public static long time;
	public static String exp ="AGDRONE";

	@SuppressWarnings("unused")
	public static void main(String[] args) throws IOException {
		FileInputStream fis = new FileInputStream("E:\\Eclipse Workspace\\Selenium Workpace\\SDET36L1-Selenium_Framework\\src\\test\\resources\\data\\commondata.properties");
		Properties p = new Properties();
		p.load(fis);
		url1 = p.getProperty("url").trim();
		
		String un = p.getProperty("username").trim();
		String pwd = p.getProperty("password").trim();
		String tout = p.getProperty("timeout").trim();
		p.getProperty("browser").trim();
		time = Long.parseLong(tout);
		System.out.print(url1.trim()+un+pwd);
	}

}
