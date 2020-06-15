package com.sreerag.insertionsort;

import java.util.ArrayList;

import com.sreerag.sorting.SortingVO;

public class InsertionSort extends SortingVO<Integer> {
	
	@Override
	public void sort() {
		
	ArrayList<Integer> list = this.getData();
	// 5 4 2 7 3
	// 2 4 5 7 3
	for(int i = 1 ; i < list.size(); i++)
	{
		int j = i;
		while(j > 0 && (list.get(j) < list.get(j - 1)))
		{
			swap(list, j, j - 1);
			j--;
		}
	}
	
	}
	public static void main(String[] args) {

		SortingVO<Integer> insertion =  new InsertionSort();
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(5);
		list.add(4);
		list.add(2);
		list.add(7);
		list.add(1);
		
		insertion.load(list);
		insertion.sort();
		insertion.print(list);
	
	}
}
