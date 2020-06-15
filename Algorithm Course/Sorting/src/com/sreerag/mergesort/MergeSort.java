package com.sreerag.mergesort;

import java.util.ArrayList;

import com.sreerag.sorting.SortingVO;

public class MergeSort extends SortingVO<Integer> {

	@Override
	public void sort() {
		
		ArrayList<Integer> list = this.getData();
		mergeSort(list, 0, list.size() - 1);
	}

	private void mergeSort(ArrayList<Integer> list, int left, int right) {
		
		if(left < right)
		{
			int mid = (left + right)/2;
			
			mergeSort(list, left, mid);
			mergeSort(list, mid + 1, right);
			
			merge(list, left, mid, right);
		}	
		
	}

	private void merge(ArrayList<Integer> list, int left, int mid, int right) {
		
		ArrayList<Integer> leftArray = new ArrayList<>();
		ArrayList<Integer> rightArray = new ArrayList<>();
		
		for(int i = left; i <= mid ; i++)
			leftArray.add(list.get(i));
				
		for(int i = mid + 1; i <= right ; i++)
			rightArray.add(list.get(i));
		
		int i = 0;
		int j = 0;
		int index = left;
		// 5 4 2 3 		4 2 11 8
		while(i < leftArray.size() && j < rightArray.size())
		{
			if(leftArray.get(i) < rightArray.get(j))
			{
				list.set(index, leftArray.get(i));
				i++;
			}
			else
			{
				list.set(index, rightArray.get(j));
				j++;
			}
			index++;
		}
		
		while(i < leftArray.size())
		{
			list.set(index, leftArray.get(i));
			i++;
			index++;
		}
		
		while(j < rightArray.size())
		{
			list.set(index, rightArray.get(j));
			j++;
			index++;
		}
		
		
	}

	public static void main(String[] args) {

		SortingVO<Integer> merge =  new MergeSort();
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(5);
		list.add(4);
		list.add(2);
		list.add(7);
		list.add(1);
		
		merge.load(list);
		merge.sort();
		merge.print(list);
	
	
	
	}
}
