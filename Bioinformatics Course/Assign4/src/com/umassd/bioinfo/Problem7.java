package com.umassd.bioinfo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Problem7 {

	
	public static void main(String[] args) throws IOException{
		
		BufferedReader bufferedReader = new BufferedReader(new FileReader(System.getProperty("user.dir")+File.separator+"inputfile3.txt"));
		
		List<String> input = new ArrayList<>();
		
		Calendar calendar = Calendar.getInstance();
		
			calendar.set(2018, 3, 8);
			System.out.println(calendar.get(Calendar.DAY_OF_WEEK));
		
		int inputCount = Integer.parseInt(bufferedReader.readLine());
		do
		{
			input.add(bufferedReader.readLine());
		}
			while(bufferedReader.ready());		
		
		/*input.add("CTTA");
		input.add("ACCA");
		input.add("TACC");
		input.add("GGCT");
		input.add("GCTT");
		input.add("TTAC");*/
		
		List<Bean> beans = eulersSet(input,inputCount);
		
		reconstructString(input,beans);
		
		bufferedReader.close();
	}

	private static void reconstructString(List<String> input, List<Bean> beans) throws IOException {
		// TODO Auto-generated method stub
		
		int init = 0;
		
		for( int i = 0 ; i < input.size() ; i++)
		{
			Bean bean = beans.get(i);
			
			String value = bean.getName();
			
			if(bean.getLinks()!=null && !bean.getLinks().isEmpty())
			{
				String link = bean.getLinks().get(0);
				
				List<String> tempInput = new ArrayList<>(input);
				List<String> tempOutput = new ArrayList<>();
				
				tempOutput.add(value);
				tempOutput.add(link);
				tempInput.remove(value);
				boolean flag = false;
				while(!flag)
				{
					for ( int j = 0 ; j < input.size() ; j++)
					{
						
							String compareToString = input.get(j);
							if(compareToString !=null && compareToString.equalsIgnoreCase(link))
							{
								if(beans.get(j).getLinks()==null)
									{
									tempInput.remove(beans.get(j).getName());
									flag = true;
									break;
									}
								link =  beans.get(j).getLinks().get(0);
								tempOutput.add(link);
								tempInput.remove(beans.get(j).getName());
								break;
							}
						
					}
				}
				if(input.size() == tempOutput.size())
					genomePathProblem(tempOutput);
				
				
				
			}
			
		
		}
		
	}
	
	private static void genomePathProblem(List<String> inputs) throws IOException {
		// TODO Auto-generated method stub
		int kmersize = inputs.get(0).length();
		
		FileWriter fileWriter = new FileWriter("output3.txt");
		StringBuilder builder = new StringBuilder();

		builder.append(inputs.get(0));
		for (int i = 1 ; i < inputs.size() ; i++)
		{
			//System.out.println(builder.toString());
			builder.append(inputs.get(i).charAt(kmersize-1));
		}
		
		fileWriter.write(builder.toString());

		fileWriter.close();
	}

	private static List<Bean> eulersSet(List<String> input, int length) {
		// TODO Auto-generated method stub
		
		List<Bean> beans = new ArrayList<>();
		for ( int i = 0 ; i < input.size() ; i++)
		{
			Bean bean = new Bean();
			String value = input.get(i);
			
			String substring = input.get(i).substring(1,length);
			
			List<String> links = new ArrayList<>();
			
			for ( int j = 0 ; j < input.size() ; j++)
			{
				String substring1 = input.get(j).substring(0, length - 1);
				if(i != j && substring.equalsIgnoreCase(substring1))
				{
					links.add(input.get(j));
				}
			}
			bean.setName(value);
			
			if(links==null || links.isEmpty())
			{
				bean.setLinks(null);
			}
			else
			{
			
				bean.setLinks(links);
			}
			
			beans.add(bean);
			
		}
		
		
		for (Bean bean : beans)
		{
		//	System.out.println(bean.getName() + " " + bean.getLinks());
		}
		
		return beans;
		
	}
}
