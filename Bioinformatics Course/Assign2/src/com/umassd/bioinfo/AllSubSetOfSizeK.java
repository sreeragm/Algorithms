package com.umassd.bioinfo;

import java.util.ArrayList;

public class AllSubSetOfSizeK {

	static ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
	
	public void subset(int[] A, int k, int start, int currLen, boolean[] used) {

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

	public static void main(String[] args) {
		int A[] = {1, 1, 1, 2, 2, 3, 3, 3, 4, 4, 5, 5, 6, 6, 6, 9, 9, 10, 11, 12};
		boolean[] B = new boolean[A.length];
		AllSubSetOfSizeK i = new AllSubSetOfSizeK();
		i.subset(A, A.length - 2, 0, 0, B);

		System.out.println(list.size());
	}

}