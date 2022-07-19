package org.vtiger.practices;

import java.nio.charset.Charset;
import java.util.Random;

public class RandomStringGenrate01 {
	public static void main(String[] args) {
		
	
	    byte[] array = new byte[7]; // length is bounded by 7
	    new Random().nextBytes (array);
	    String generatedString = new String(array, Charset.forName("UTF-8"));

	    System.out.println(generatedString);
	}

}
