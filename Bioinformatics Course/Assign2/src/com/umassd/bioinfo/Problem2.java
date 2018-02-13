package com.umassd.bioinfo;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem2 {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		List<Integer> inputL = new ArrayList<>();
		/*inputL.add(2);
		inputL.add(998);
		inputL.add(1000);
		
		{1, 1, 1, 2, 2, 3, 3, 3, 4, 4, 5, 5, 6, 6, 6, 9, 9, 10, 11, 12, 15}. */

		inputL.add(1);
		inputL.add(1);
		inputL.add(1);
		inputL.add(2);
		inputL.add(2);
		inputL.add(3);
		inputL.add(3);
		inputL.add(3);
		inputL.add(4);
		inputL.add(4);
		inputL.add(5);
		inputL.add(5);
		inputL.add(6);
		inputL.add(6);
		inputL.add(6);
		inputL.add(9);
		inputL.add(9);
		inputL.add(10);
		inputL.add(11);
		inputL.add(12);
		inputL.add(15);
		
		System.out.println(inputL);
	//	ArrayList<ArrayList<Integer>> output = anotherBruteForcePDP1(inputL, inputL.size());
	
		FileWriter fileWriter = new FileWriter("file.txt");
		fileWriter.write(getSubsets(inputL, inputL.size() - 2).toString());
		fileWriter.close();
		//System.out.println(getSubsets(inputL, inputL.size() - 2));
		//System.out.println(output);
	}

	private static ArrayList<ArrayList<Integer>> anotherBruteForcePDP1(List<Integer> inputL, int size) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		List<Set<Integer>> subsets = getSubsets(inputL, inputL.size() - 2);
		
		FileWriter fileWriter = new FileWriter("file.txt");
		fileWriter.write(subsets.toString());
		return null;
	}

	private static 	ArrayList<ArrayList<Integer>> anotherBruteForcePDP(List<Integer> inputL, int size) {
		// TODO Auto-generated method stub
		
		Collections.sort(inputL);
		int M = inputL.get(size-1);
		
		ArrayList<Integer> X = new ArrayList<>();
		List<Integer> multiset = new ArrayList<>();
		
		List<Integer> correctmultiset = new ArrayList<>();
		
		ArrayList<ArrayList<Integer>> superoutput = new ArrayList<ArrayList<Integer>>();
		while(!inputL.equals(correctmultiset))
		{
			for ( int i = 0 ; i < size; i++)
			{
				X.add(0);
				
				for ( int j = 0 ; j < size - 2 ; j++)
					X.add(inputL.get(i));
				
				X.add(M);
				
				multiset = calculateMultiSet(X);
				
				if(inputL.equals(multiset))
				{
					correctmultiset = multiset;
					superoutput.add(X);
				}
				X = new ArrayList<>();
					
			}

			
		}	
		
		return superoutput;
	}
	
	private static List<Integer> calculateMultiSet(List<Integer> list) {
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
		
		for ( int value : output)
		{
			//System.out.println(value);
		}
		
		return output;
	}
	
	private static void getSubsets(List<Integer> superSet, int k, int idx, Set<Integer> current,List<Set<Integer>> solution) {
	    //successful stop clause
	    if (current.size() == k) {
	        solution.add(new HashSet<>(current));
	        return;
	    }
	    //unseccessful stop clause
	    if (idx == superSet.size()) return;
	    Integer x = superSet.get(idx);
	    current.add(x);
	    //"guess" x is in the subset
	    getSubsets(superSet, k, idx+1, current, solution);
	    current.remove(x);
	    //"guess" x is not in the subset
	    getSubsets(superSet, k, idx+1, current, solution);
	}

	public static List<Set<Integer>> getSubsets(List<Integer> superSet, int k) throws InterruptedException {
	    List<Set<Integer>> res = new ArrayList<>();
	    getSubsets(superSet, k, 0, new HashSet<Integer>(), res);
	    
	    Thread.sleep(5000);
	    return res;
	}
	
}
