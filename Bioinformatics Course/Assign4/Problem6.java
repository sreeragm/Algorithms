package com.umassd.bioinfo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Problem6 {

	public static void main(String[] args) throws IOException{

		
		BufferedReader bufferedReader = new BufferedReader(new FileReader(System.getProperty("user.dir")+File.separator+"inputfile2.txt"));

		List<String> inputs = new ArrayList<>();
		do
		{
			inputs.add(bufferedReader.readLine());
		}
		while(bufferedReader.ready());

		
		//System.out.println();
		genomePathProblem(inputs);
		
		bufferedReader.close();
	
	}

	private static void genomePathProblem(List<String> inputs) throws IOException {
		// TODO Auto-generated method stub
		int kmersize = inputs.get(0).length();
		
		FileWriter fileWriter = new FileWriter("output1.txt");
		StringBuilder builder = new StringBuilder();

		builder.append(inputs.get(0));
		for (int i = 1 ; i < inputs.size() ; i++)
		{
			//System.out.println(builder.toString());
			builder.append(inputs.get(i).charAt(kmersize-1));
		}
		
		fileWriter.write(builder.toString());

		fileWriter.close();
	}
	
}
