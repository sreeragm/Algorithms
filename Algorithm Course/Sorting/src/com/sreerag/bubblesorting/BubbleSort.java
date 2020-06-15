package com.sreerag.bubblesorting;

import java.util.ArrayList;
import java.util.List;

import com.sreerag.sorting.SortingVO;

public class BubbleSort extends SortingVO<Integer> {

	@Override
	public void sort() {

		List<Integer> list = getData();
		
		for(int i = 0 ; i < list.size() - 1 ; i++)
		{
			for(int j = 0 ; j < list.size() - i - 1 ; j++)
			{
				if(list.get(j) > list.get(j + 1))
				{
					int temp = list.get(j);
					list.set(j, list.get(j + 1));
					list.set(j + 1, temp);
				}
			}
		}
	}
	
	public static void main(String[] args) {
		SortingVO<Integer> bubble =  new BubbleSort();
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(5);
		list.add(4);
		list.add(2);
		list.add(7);
		list.add(1);
		
		bubble.load(list);
		bubble.sort();
		bubble.print(list);
	}
}
