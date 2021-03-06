package com.sreerag.binarysearch;

import java.util.ArrayList;

import com.sreerag.sorting.SortingVO;

public class BinarySearch extends SortingVO<Integer> {
	
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
	
	@Override
	public int search(ArrayList<Integer> list, Integer value) {
		int start = 0;
		int end = list.size() - 1;
		
		int mid = (start + end)/2;
		
		
		while(start <= end)
		{
			if(list.get(mid) == value)
				return mid;
			else
				if(list.get(mid) < value)
				{
					start = mid + 1;
				}
				else
				{
					end = mid - 1;
				}
			 mid = (start + end)/2;
		}
		
		return -1;
		
	}
	
	public static void main(String[] args) {

		SortingVO<Integer> bsearch =  new BinarySearch();
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(15);
		list.add(24);
		list.add(12);
		list.add(27);
		list.add(31);
		
		bsearch.load(list);
		bsearch.sort();
		bsearch.print(list);
		System.out.println(bsearch.search(list, 32));
	
	}

}
