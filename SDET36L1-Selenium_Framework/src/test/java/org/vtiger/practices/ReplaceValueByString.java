package org.vtiger.practices;

public class ReplaceValueByString {
	public static void main(String[] args) {
		String statement= "MY NAME IS ###";
		String result = statement.replace("###", "YOGI"); //using replace method of string class
		System.out.println(result);
		
		String address="I am from %s %d";
		String results= String.format(address, "Mumbai",410209); //using format method of string class
		System.out.println(results);
	}

}
