package com.sreerag.selectionsort;

import java.util.ArrayList;

import com.sreerag.sorting.SortingVO;

public class SelectionSort extends SortingVO<Integer> {

	@Override
	public void sort() {
		// 5 4 2 7 1
		ArrayList<Integer> list = this.getData();
		
		for(int i = 0 ; i < list.size() - 1 ; i++)
		{
			int swapindex = i;
			int min = list.get(i);
			
			for(int j = i + 1 ; j < list.size(); j++)
			{
				if(list.get(j) < min)
				{
					swapindex = j;
					min = list.get(j);
				}
			}
			
			swap(list, i, swapindex);
			
		}
	}
	
	public static void main(String[] args) {
		SortingVO<Integer> selection =  new SelectionSort();
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(5);
		list.add(4);
		list.add(2);
		list.add(7);
		list.add(1);
		
		selection.load(list);
		selection.sort();
		selection.print(list);
	
	
	}

}
