package com.umassd.bioinfo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Problem1 {

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new FileReader(System.getProperty("user.dir")+File.separator+"input1.csv"));
		
		String[] inputarray = bufferedReader.readLine().split(",");

		System.out.println(PatternCount(inputarray[0], inputarray[1]));
		
		bufferedReader.close();
	}
	
	public static int PatternCount(String text, String pattern)
	{
		int count = 0;
		
		for(int i = 0; i<=(text.length() - pattern.length()); i++)
		{
			String subString = text.substring(i,i+pattern.length());
			
			if(subString.equalsIgnoreCase(pattern))
			{
				count = count + 1;
			}
			
		}
		
		return count;
		
	}
	
}


