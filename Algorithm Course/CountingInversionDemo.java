

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CountingInversionDemo {

	
	public static void main(String[] args) throws IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Enter the number of elements for counting significant inversion: ");
		
		String inputvalue=br.readLine();
		
		System.out.println(inputvalue);
		
		List<Integer> num=new ArrayList<>();
		
		if(!checkisEmpty(inputvalue) && checkNumber(inputvalue))
		{
			int value=Integer.parseInt(inputvalue);
			
			for(int i=0;i<value;i++)
			{
				String inversionvalue;
				do
				{
					System.out.println("Element no : "+(i+1));
					inversionvalue=br.readLine();
					
					if(!checkisEmpty(inversionvalue) && checkNumber(inversionvalue))
					{
						num.add(Integer.valueOf(inversionvalue));
					}
				}
				while(!((!checkisEmpty(inversionvalue) && checkNumber(inversionvalue))));
				
				
			}
		}
		
	
		callCountingInversion(num);
		
		
	}
	
	private static void callCountingInversion(List<Integer> list) {

		
		
		List<Integer> subList1=list.subList(0, list.size()/2);
		List<Integer> subList2=list.subList(list.size()/2, list.size());
		
		CountingSignificantInverions object1 = getSignificantInversions(subList1.get(0).intValue(),subList1.subList(1,subList1.size()));

		
		CountingSignificantInverions object2 = getSignificantInversions(subList2.get(0).intValue(),subList2.subList(1,subList2.size()));
		
		Collections.sort(subList1);
		Collections.sort(subList2);
		
		int conversionCount=getCombinedCount(subList1,subList2);
		
		int total=object1.getCount()+object2.getCount()+conversionCount;
		System.out.println(" Total Significant Counting Inversions : "+total);
	}

	private static CountingSignificantInverions getSignificantInversions(int val, List<Integer> subList) 
	{
		int count=0;
		
		int recursiveCount=0;
		CountingSignificantInverions returnobj;
		
		for (int value : subList)
		{
			if( ( val) > (2*value) )
			{
				count=count+1;
			}
		}

		
		if(subList!=null && subList.size()>0)
		{
			CountingSignificantInverions obj=getSignificantInversions(subList.get(0).intValue(),subList.subList(1,subList.size()));
			recursiveCount=obj.getCount();
		}
		
		
		returnobj=new CountingSignificantInverions();
		
	
		returnobj.setCount(count+recursiveCount);
		returnobj.setList(subList);
		
		
		
		return returnobj;
	}

	private static int getCombinedCount(List<Integer> SubList1, List<Integer> SubList2) {
		

		
		int countinversions=0;
		for(int i=0;i<SubList2.size()-1;i++)
		{
			for(int j=0;j<SubList1.size();j++)
			{
			
				if(2*SubList2.get(i)<(SubList1.get(j)))
				{
					countinversions=countinversions+1;
				}
				
			}
		}
		
		return countinversions;
	}


	private static boolean checkNumber(String inputvalue) {
		char[] number = inputvalue.toCharArray();
		for(int i=0;i<number.length;i++){
			if(!(number[i]=='1' || number[i]=='2' || number[i]=='3' || number[i]=='4' || number[i]=='5' || number[i]=='6' || number[i]=='7' || number[i]=='8' || number[i]=='9' || number[i]=='0'))
				return false;
		}
		return true;
	}

	private static boolean checkisEmpty(String inputvalue) {
		
		if(inputvalue!=null && !inputvalue.isEmpty())
		{
			return false;
		}
		else
			return true;
	}


}
