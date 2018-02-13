package com.umassd.bioinfo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Problem3 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader bufferedReader = new BufferedReader(new FileReader(System.getProperty("user.dir")+File.separator+"input3.csv"));

		String inputarray = bufferedReader.readLine();
		
		System.out.println(inputarray);
		
		System.out.println(getReverseComplement(inputarray));
		
		bufferedReader.close();
	}
	
	public static String getReverseComplement(String input) throws FileNotFoundException
	{
		StringBuilder output = null;
		
		StringBuilder builder = new StringBuilder(input);
		
		output = builder.reverse();
		
		for ( int i = 0 ;i < output.length(); i++)
		{
			System.out.println(output.charAt(i));
			if(output.charAt(i) == 'A')
				output.setCharAt(i, 'T');
			else
				if(output.charAt(i) == 'T')
					output.setCharAt(i, 'A');
				else
					if(output.charAt(i) == 'G')
						output.setCharAt(i, 'C');
					else
						if(output.charAt(i) == 'C')
							output.setCharAt(i, 'G');
						
		}
		
		PrintWriter out = new PrintWriter("filename.txt");
		out.print(output);
		
		out.close();
		return output.toString();
	}
}
