package com.umassd.bioinfo;

public class Problem6 {

	private static double MATCH_SCORE = 1;
	
	private static double MISMATCH_SCORE = -1;
	
	private static double INDEL_SCORE = -0.5;
	
	
	public static void main(String[] args) {
		
		String input1 = "1213434222";
		String input2 = "1343422421";
		
		findLocalAlignment(input1, input2);
	}


	private static void findLocalAlignment(String input1, String input2) {
		// TODO Auto-generated method stub
		
		char [] input1Arr = input1.toCharArray();
		
		char [] input2Arr = input2.toCharArray();
		
		double[][] outputArray = new double[input1Arr.length+1][input2Arr.length+1];
		double[][] outputArrayDirections = new double[input1Arr.length+1][input2Arr.length+1];
		
		outputArray = initialize(outputArray , input1Arr, input2Arr);
		
		double highestcount = 0;
		int endnode1 = 0;
		int endnode2 = 0;
		for(int i = 0 ; i < input2Arr.length ; i++)
			for(int j = 0 ; j < input1Arr.length ; j++)
			{
				double comparator1;
				double comparator2;
				double comparator3;
				double comparator4 = 0;
				
				if(input2Arr[i] == input1Arr[j])
				{
					comparator1 = outputArray[j][i] + Problem6.MATCH_SCORE;
					
				}
				else
				{
					comparator1 = outputArray[j][i] + Problem6.MISMATCH_SCORE;
					
				}
				
				comparator2 = outputArray[j][i+1]  + Problem6.INDEL_SCORE;
				
				comparator3 = outputArray[j+1][i]  + Problem6.INDEL_SCORE;
				
				if((comparator1 >= comparator2) && (comparator1 >= comparator3) && (comparator1 >= comparator4))
				{
					 outputArrayDirections[j+1][i+1] = 1;
					 outputArray[j+1][i+1] = comparator1;
					 
					 if(comparator1 >= highestcount)
					 {
						 highestcount = comparator1;
						 endnode1 = i;
							endnode2 = j;
					 }
				}
				else
					if((comparator2 >= comparator1) && (comparator2 >= comparator3) && (comparator2 >= comparator4))
					{
						
						 outputArrayDirections[j+1][i+1] = 2;
						 outputArray[j+1][i+1]  = comparator2;
						 
						 if(comparator2 >= highestcount)
						 {
							 highestcount = comparator2;
							 endnode1 = i;
								endnode2 = j;
						 }
					}
					else
						if((comparator3 >= comparator1) && (comparator3 >= comparator2) && (comparator3 >= comparator4))
						{
							
							 outputArrayDirections[j+1][i+1] = 3;
							 outputArray[j+1][i+1] = comparator3;
							 
							 
							 if(comparator3 >= highestcount)
							 {
								 highestcount = comparator3;
								 endnode1 = i;
									endnode2 = j;
							 }
						}
						else
						{
							 
							outputArray[j+1][i+1] = comparator4;
							 
							 if(comparator4 >= highestcount)
							 {
								 highestcount = comparator4;
								 endnode1 = i;
									endnode2 = j;
							 }
						}
				
		
			}
		System.out.println(highestcount);
		StringBuilder alignmentString1 = new StringBuilder();
		StringBuilder alignmentString2 = new StringBuilder();
		while((endnode2+1) != 0 && (endnode1+1) !=0)
		{
			if(outputArrayDirections[endnode2+1][endnode1+1] == 1)
				{
				alignmentString1.append(input1Arr[endnode2]);
				alignmentString2.append(input2Arr[endnode1]);
				endnode1 = endnode1 - 1;
				endnode2 = endnode2 - 1;
				
				}
			else
				if(outputArrayDirections[endnode2+1][endnode1+1] == 2)
				{
					alignmentString1.append(input1Arr[endnode2]);
					alignmentString2.append("_");
				endnode2 = endnode2 - 1;
				
				}
				else
				{
					alignmentString1.append("_");
					alignmentString2.append(input2Arr[endnode1]);
					endnode1 = endnode1 - 1;
					
				}
		}
		System.out.println(alignmentString1.reverse().toString());
		System.out.println(alignmentString2.reverse().toString());
	}


	private static double[][] initialize(double[][] outputArray, char[] input1Arr, char[] input2Arr) {
		// TODO Auto-generated method stub
		
		for(int i = 0 ; i <= input2Arr.length ; i++)
		{
			outputArray[0][i] = 0;
		}
			for(int j = 0 ; j <= input1Arr.length ; j++)
			{
				outputArray[j][0] = 0;
			}
		
		return outputArray;
	}
}
