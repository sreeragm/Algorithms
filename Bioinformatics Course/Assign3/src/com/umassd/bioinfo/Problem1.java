package com.umassd.bioinfo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * @author sreerag
 * @desc: Problem1 Assign3 : find the most probableKmer
 */
public class Problem1 {

public static void main(String[] args) throws IOException {

	BufferedReader bufferedReader = new BufferedReader( new FileReader(System.getProperty("user.dir")+ File.separator+"input1.csv"));

	String[] inputarray = bufferedReader.readLine().split(",");
	
	int length = Integer.parseInt(inputarray[1]);
	
	double matrix [][] = new double[4][length];
	for (int j = 0 ; j < 4 ; j++)
	{
	
		String []rowarray = inputarray[j+2].split(" ");

		for (int i = 0 ; i < length; i++)
		{
			matrix[j][i] = Double.parseDouble(rowarray[i]);
		}

	}
	
	findMostProbableKMer(inputarray[0], length, matrix);
	
	bufferedReader.close();
}

private static void findMostProbableKMer(String input, int length, double[][] matrix) {
	// TODO Auto-generated method stub

	char inputArray[] = input.toCharArray();

	HashMap<String,Double> outputMap = new HashMap<String,Double>();
	List<String> kmers = new ArrayList<String>();
	
	for (int i = 0 ; i < (inputArray.length - length + 1); i++)
	{
		char tempchararray[] = new char[length];
		double probability = 1;
		
		//System.out.println(i);
		for( int j = i,k = 0 ; k < length ; j++,k++)
		{
			tempchararray[k] = inputArray[j];
			
			switch (inputArray[j]) {
			case 'A':
				probability = probability * matrix[0][k];
				break;

			case 'C':
				probability = probability * matrix[1][k];
				break;
			
			case 'G':
				probability = probability * matrix[2][k];
				break;
				
			case 'T':
				probability = probability * matrix[3][k];
				break;	
			default:
				break;
			}
		}
		
		if(!outputMap.containsKey(new String(tempchararray)))
				outputMap.put(new String(tempchararray), probability);
		kmers.add(new String(tempchararray));
	}
	
	
	double maxValueInMap=(Collections.max(outputMap.values()));  // This will return max value in the Hashmap
	
	for ( String value : kmers)
	{
		if(outputMap.get(value)!=null && outputMap.get(value)==maxValueInMap)
		{
			System.out.println(value);
			break;
		}
		
	}
	
}	
	
}
