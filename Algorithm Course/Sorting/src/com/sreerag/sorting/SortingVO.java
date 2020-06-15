package com.sreerag.sorting;

import java.util.ArrayList;

public class SortingVO<E> {

	private ArrayList<E> data;
	
	
	public ArrayList<E> getData()
	{
		return data;
	}
	
	public void swap(ArrayList<E> list, int i , int j)
	{
		E temp = list.get(i);
		list.set(i, list.get(j));
		list.set(j, temp);
	}
	
	public void sort() {};
	
	public int search(ArrayList<E> list, E value) { return -1; };
	
	public void load(ArrayList<E> data)
	{
		this.data = data;
	}
	
	
	public void print(ArrayList<E> list)
	{
		for(E value : list)
		{
			System.out.print(value + "--");
		}
		System.out.println();
	}
}