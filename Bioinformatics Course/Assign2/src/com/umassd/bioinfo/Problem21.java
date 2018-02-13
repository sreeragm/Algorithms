package com.umassd.bioinfo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem21 {

	static ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
	
	static long startime;
	static long endtime; 
	public static void main(String[] args) {
		
		startime = Calendar.getInstance().getTimeInMillis();
		int[] inputL = {1, 1, 1, 2, 2, 3, 3, 3, 4, 4, 5, 5, 6, 6, 6, 9, 9, 10, 11, 12, 15};
	
		//int [] inputL = {2, 3, 5,7};
		System.out.print("Input : ");
		for ( int value : inputL) 
		System.out.print(value + " ");
		System.out.println();
		callAnotherBruteForcePDP(inputL);
	}

	private static void callAnotherBruteForcePDP(int[] inputL) {
		// TODO Auto-generated method stub

		
		Set<ArrayList<Integer>> masterOutput = new HashSet<ArrayList<Integer>>();
		
		int[] duplicate = Arrays.copyOf(inputL, inputL.length-1);

		boolean[] B = new boolean[duplicate.length];
		
		subset( duplicate , 5, 0, 0, B);
		
		//System.out.println(list);
		List<Integer> inputarrayList = new ArrayList<>();
		for ( int val : inputL)
			inputarrayList.add(val);
		
		for( int i = 0 ; i < list.size() ; i++)
		{
			List<Integer> list1 = new ArrayList<>();
			list1.add(0);
			
//			List<Integer> list = list.get(i);
			list1.addAll(list.get(i));
			list1.add(inputL[inputL.length-1]);
			
			//System.out.println(list1);
			
			List<Integer> multiset = calculateMultiSet(list1);

			//System.out.println(multiset);
			//System.out.println(inputarrayList);
			if(inputarrayList.equals(multiset))
			{
				//System.out.println("Inside");
				masterOutput.add((ArrayList<Integer>) list1);
			}
		}
		
		System.out.println("Output " + masterOutput);
		endtime = Calendar.getInstance().getTimeInMillis();
		
		System.out.println("Time taken to execute " + (endtime - startime) + " milliseconds");
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
				if(list.get(j) - duplicateArray.get(i)!=0)
				output.add(list.get(j) - duplicateArray.get(i));
				
			}
		}
		
		Collections.sort(output);
		
		//System.out.println(output);
		//System.out.println(output.size());
		for ( int value : output)
		{
		//	System.out.println(value);
		}
		
		return output;
	}
	
	/*
	 * Used reference code to extract k subsets of list n 
	 * http://algorithms.tutorialhorizon.com/print-all-combinations-of-subset-of-size-k-from-given-array/
	 * and modified the code as per requirement of the algo
	 * 
	 */
	
	public static void subset(int[] A, int k, int start, int currLen, boolean[] used) {

		ArrayList<Integer> sublist = null;
		
		if (currLen == k) {
			sublist = new ArrayList<>();
			for (int i = 0; i < A.length; i++) {
				if (used[i] == true) {
					
					sublist.add(A[i]);
				}
			}
			
			list.add(sublist);
	
			return;
		}
		if (start == A.length) {
			return;
		}
		// For every index we have two options,
		// 1.. Either we select it, means put true in used[] and make currLen+1
		used[start] = true;
		subset(A, k, start + 1, currLen + 1, used);
		// 2.. OR we dont select it, means put false in used[] and dont increase
		// currLen
		used[start] = false;
		subset(A, k, start + 1, currLen, used);
	}
}
