package com.umassd.bioinfo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Assign3 {

	static long startime;
	static long endtime; 
	
	public static void main(String[] args) {
/*		List<Integer> L = new ArrayList<>();
		L.add(2);
		L.add(2);
		L.add(3);
		L.add(3);
		L.add(4);
		L.add(5);
		L.add(6);
		L.add(7);
		L.add(8);
		L.add(10);
	startime = Calendar.getInstance().getTimeInMillis();	
*/	
		startime = Calendar.getInstance().getTimeInMillis();
		int[] inputL = {1, 1, 1, 2, 2, 3, 3, 3, 4, 4, 5, 5, 6, 6, 6, 9, 9, 10, 11, 12, 15};
List<Integer> L = new ArrayList<>();
L.add(1);
L.add(1);
L.add(1);
L.add(2);
L.add(2);
L.add(3);
L.add(3);
L.add(3);
L.add(4);
L.add(4);
L.add(5);
L.add(5);
L.add(6);
L.add(6);
L.add(6);
L.add(9);
L.add(9);
L.add(10);
L.add(11);
L.add(12);
L.add(15);

System.out.println("Input "+L);
		
		callPartialDigest(L);
		
		
	}

	private static void callPartialDigest(List<Integer> l) {
		// TODO Auto-generated method stub
		int n = 7;
		int width;
		int y;
		List<Integer> output = new ArrayList<>();
		output.add(0);
		
		width = l.get(l.size() - 1);
		output.add(width);
		l.remove(l.size() - 1);
		
		//System.out.println(output);
		for ( int i =1 ; i< 6 ; i++)
			{
			width = l.get(l.size() - 1);
				int y1 = Math.abs(output.get(0) - width);
				int y2 = Math.abs(output.get(output.size()-1) - width);
				boolean flag = false;
				
				y = y1;
				while (!flag && !l.isEmpty())
				{
					List<Integer> tempList = new ArrayList<>();
					
					for ( int k = 0 ; k < output.size() ; k++)
					{
						tempList.add(Math.abs(output.get(k) - y));
					}

					Collections.sort(tempList);
					if(l.containsAll(tempList))
					{
						flag = true;
						output.add(i,y);
						
						for (int j = 0; j < tempList.size() ; j++)
						{
							if((l.contains(tempList.get(j))))
							{
								for (int k =0 ; k < l.size() ; k++)
								{
									if(l.get(k) == tempList.get(j))
									{
										l.remove(k);
										break;
									}
								}
							}
						}
						//l.remove(l.size() - 1);
						
					}
					else
					{
						y = y2;
					}
				}
				
				//System.out.println(l);
				
				
				
			}
		Collections.sort(output);
		System.out.println("Output "+output);
endtime = Calendar.getInstance().getTimeInMillis();
		
		System.out.println("Time taken to execute " + (endtime - startime) + " milliseconds");
	}
	
}
