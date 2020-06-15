package com.sreerag.quicksort;

import java.util.ArrayList;

import com.sreerag.sorting.SortingVO;

public class QuickSort extends SortingVO<Integer> {

	@Override
	public void sort() {
		
		ArrayList<Integer> list = this.getData();
		quicksort(list, 0, list.size() - 1);
	}
	
	private void quicksort(ArrayList<Integer> list, int left, int right) {
		
		if(left < right)
		{
			int pivot = partition(list, left, right);
			
			quicksort(list, left, pivot - 1);
			quicksort(list, pivot + 1, right);
		}
	}
	
	private int partition(ArrayList<Integer> list, int left, int right) {
		
		// 5 4 2 7 1 9
		
		int pivot = list.get(right);
		
		int i = left - 1;
		
		for(int j = left ; j < right ; j++)
		{
			if(list.get(j) <= pivot)
			{
				i++;
				swap(list, i, j);
			}
			
		}
		
		swap(list, i + 1, right);
		
		return (i + 1);
		
	}

	public static void main(String[] args) {
		
		SortingVO<Integer> quick =  new QuickSort();
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(5);
		list.add(4);
		list.add(2);
		list.add(7);
		list.add(1);
		
		quick.load(list);
		quick.sort();
		quick.print(list);
	
	
	
	}

}
