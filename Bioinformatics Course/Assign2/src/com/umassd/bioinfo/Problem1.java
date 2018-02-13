package com.umassd.bioinfo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem1 {

	public static void main(String[] args) throws IOException {
		
		/*BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Input Number of Elements in X :");
		String inputCount = bufferedReader.readLine();
		
		int [] inputArray = {0,2,4,7,10};*/
		
		List<Integer> list = new ArrayList<>();
		//list.add(0);
		list.add(0);
		list.add(6);
		list.add(9);
		list.add(10);
		list.add(11);
		list.add(12);
		list.add(15);
		/*list.add(0);
		list.add(4);
		list.add(4);
		list.add(6);
		list.add(9);
		list.add(10);
		list.add(11);
		list.add(12);
		list.add(15);*/
		
		//[[0, 6, 9, 10, 11, 12, 15], [0, 3, 4, 5, 6, 9, 15]]
		
		//[0, 4, 4, 6, 9, 10, 11, 12, 15]
		System.out.println(" Input : " + list);
		calculateMultiSet(list);
	}

	private static void calculateMultiSet(List<Integer> list) {
		// TODO Auto-geneated method stub
		
		List<Integer> duplicateArray = list;
		
		List<Integer> output = new ArrayList<>();
		
		for ( int i = 0 ; i < list.size() ; i++)
		{
			for (int j = i+1 ; j < (duplicateArray.size()) ; j++ )
			{
				//System.out.println(list.get(j) - duplicateArray.get(i));
				output.add(list.get(j) - duplicateArray.get(i));
				
			}
		}
		
		Collections.sort(output);
	
		
		System.out.println(" Output : " + output);
	}
	
}
