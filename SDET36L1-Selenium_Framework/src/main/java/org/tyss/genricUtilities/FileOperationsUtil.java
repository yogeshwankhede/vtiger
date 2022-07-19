package org.tyss.genricUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * This class contains reusable methods for csv and property file
 * @author yogir
 *
 */
public final class FileOperationsUtil {
	private Properties properties;



	public void intiallizeProperyFile(String filePath) {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(filePath);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		properties = new Properties();
		try {
			properties.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * This Method is used to getDataFRomPropertyFile
	 * @param 
	 */
	public String getDataFromProperty(String key) {
		return properties.getProperty(key).trim();	
	}
}
