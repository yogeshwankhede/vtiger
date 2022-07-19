package org.vtiger.practices;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

public class FetchDataFromCSV {
	public static void main(String[] args) throws IOException, CsvException {
		CSVReader reader = new CSVReader(new FileReader(".\\src\\test\\resources\\data\\Try.csv"));
		List<String[]> allData = reader.readAll();
		
		int count = allData.size();
		for(int i=0; i<=count;i++) 
		{
			String[] dataLine = allData.get(i+1);
			
			for(int j =1; j<=dataLine.length;j++) 
			{
			String data = dataLine[j-1];
			System.out.println(data);
			}
		}
		
	}

}
