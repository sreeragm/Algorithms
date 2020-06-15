package com.sreerag.bucketsort;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

import com.sreerag.insertionsort.InsertionSort;
import com.sreerag.sorting.SortingVO;

public class BucketSort extends SortingVO<Integer> {

	@Override
	public void sort() {
		
		ArrayList<Integer> list = getData();
		
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		Map<Integer, ArrayList<Integer>> map = new TreeMap<>();
		
		for(int value : list)
		{
			int bucketNo = getBucketValue(value);
			
			if(map.containsKey(bucketNo))
			{
				ArrayList<Integer> tempList = map.get(bucketNo);
				tempList.add(value);
				map.put(bucketNo, tempList);
			}
			else
			{
				ArrayList<Integer> tempList = new ArrayList<>();
				tempList.add(value);
				map.put(bucketNo, tempList);
			}
		}
		
		for(int bucket : map.keySet())
		{
			if(map.get(bucket).size() > 1)
			{
				InsertionSort insertion = new InsertionSort();
				ArrayList<Integer> temptemp = map.get(bucket);
				insertion.load(temptemp);
				insertion.sort();
				map.put(bucket, temptemp);
			}	
		}
		list.clear();
		for(int bucket : map.keySet())
		{
			ArrayList<Integer> temptemptemp = map.get(bucket);
			
			for(int value : temptemptemp)
				list.add(value);
		}
		
		print(result);
	}
	
	private int getBucketValue(int value) {
		
		return value/10;
	}

	public static void main(String[] args) {

		SortingVO<Integer> bucket =  new BucketSort();
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(15);
		list.add(24);
		list.add(12);
		list.add(27);
		list.add(31);
		
		bucket.load(list);
		bucket.sort();
		bucket.print(list);
	
	
	
	
	}
}
