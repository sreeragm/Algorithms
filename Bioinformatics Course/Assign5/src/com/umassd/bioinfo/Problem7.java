package com.umassd.bioinfo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Problem7 {

	public static void main(String[] args) throws IOException{
		
		BufferedReader bufferedReader = new BufferedReader(new FileReader(System.getProperty("user.dir")+File.separator+"inputfile.txt"));
		
		int money = Integer.parseInt(bufferedReader.readLine());
		
		List<Integer> denominations = new ArrayList<>();
		
		String[] denom = bufferedReader.readLine().split(",");
		
		for(String value : denom) 
		{
			denominations.add(Integer.parseInt(value)); 
		}
		
		
		HashMap<Integer, Integer> noofCoins = greedyChange(money, denominations);

		System.out.println(noofCoins.get(noofCoins.size()-1));
		
		bufferedReader.close();
	}

	private static HashMap<Integer,Integer> greedyChange(int money, List<Integer> denominations) {
		// TODO Auto-generated method stub
		HashMap<Integer,Integer> map = new HashMap<>();
		map.put(0, 0);
		for (int i = 1 ; i <= money ; i++)
		{

			map.put(i, Integer.MAX_VALUE);

			for ( int j = 0 ; j < denominations.size() ; j++)
			{
				
				if(i >= denominations.get(j))
				{
					
					if(map.get(i - denominations.get(j)) + 1 < map.get(i))
					{
						map.put(i, map.get(i - denominations.get(j)) + 1);
					
					}
				}
			}
		}
		
		return map;
	}
}
