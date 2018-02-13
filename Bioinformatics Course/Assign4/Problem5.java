package com.umassd.bioinfo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem5 {

	public static void main(String[] args) throws IOException {
		System.out.println(System.getProperty("user.dir"));
		BufferedReader bufferedReader = new BufferedReader(new FileReader(System.getProperty("user.dir")+File.separator+"inputfile.txt"));
		
		int count = Integer.parseInt(bufferedReader.readLine());
		String input = "";
			
		do
		{
			input = input + bufferedReader.readLine();
		}
			while(bufferedReader.readLine()!=null);		

		
		//System.out.println();
		implementCompositionProblem(count, input);
		
		bufferedReader.close();
	}

	private static void implementCompositionProblem(int count, String input) throws IOException {
		// TODO Auto-generated method stub
		
		FileWriter fileWriter = new FileWriter("output.txt");
		Set<String> output = new HashSet<>();
		
		for (int i = 0 ; i < (input.length() - count + 1); i++)
		{
			String substring = input.substring(i,i + count);
			//System.out.println(substring);
			output.add(substring);
		
		}
		List<String> list = new ArrayList<>(output);
		
		Collections.sort(list);
		for (String outputname : list)
		{
			fileWriter.write(outputname);
			fileWriter.write("\n");
		}

		
		fileWriter.close();
	}
}
