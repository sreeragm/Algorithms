package com.umassd.bioinfo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;

public class Problem2 {

	public static void main(String[] args) throws IOException {
	
		BufferedReader bufferedReader = new BufferedReader(new FileReader(System.getProperty("user.dir")+File.separator+"input2.csv"));
		
		String[] inputarray = bufferedReader.readLine().split(",");
		
		mostFrequesntKmer(inputarray[0],Integer.parseInt(inputarray[1]));
		
		bufferedReader.close();
	}
	
	public static HashMap<String,Integer> mostFrequesntKmer(String data, int k)
	{
		HashMap<String,Integer> output = new HashMap<>();
		
		for ( int i =0 ; i < data.length()-k ; i++)
			{
				String pattern = data.substring(i, i+k);
				
				int count = PatternCount(data, pattern);
				
				if(!output.containsValue(pattern) || output.get(pattern) < count)
					output.put(pattern, count);
				
			}

		
		/*
		 * reference to get the max value of the pattern
		 *  https://stackoverflow.com/questions/5911174/finding-key-associated-with-max-value-in-a-java-map
		 */
		
		int maxValueInMap=(Collections.max(output.values()));  // This will return max value in the Hashmap
		for (Entry<String, Integer> entry : output.entrySet()) {  // Itrate through hashmap
			if (entry.getValue()==maxValueInMap) {
				System.out.println(entry.getKey());     // Print the key with max value
			}
		}
		return output;
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
