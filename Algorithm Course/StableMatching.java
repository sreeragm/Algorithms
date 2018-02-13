package com.umassd.Assgn1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


/**
 * 
 * Quesion 2 of Assignment 1
 * To find: Stable matching of the proposal and reject algorithm problem
 * @author sreerag
 * 
 * */

public class StableMatching {

	public static void main(String[] args) throws IOException {

		String welcome_message=("******** Enter input: ********** \n 1:Man-propose woman normal order \n 2.Man-propose woman reverse order \n 3.Woman propose man \n 4.exit");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String inputvalue;
		
		do
		{
			System.out.println("\n"+welcome_message);
			 inputvalue=br.readLine();
			if (inputvalue == null || inputvalue.isEmpty() || (!inputvalue.equals("1") && !inputvalue.equals("2") && !inputvalue.equals("3") && !inputvalue.equals("4"))) {
				System.out.println("Invalid Input");
			}
			else
			{
				

				List<String> men=populateMen();
				List<String> women=populateWomen();
				HashMap<String,String[]> husbandWife=null;
				String[] husband;
				String[] wife;
				
				HashMap<String,List<String>> menPreference=setMensPrefence();
				HashMap<String,List<String>> womenPreference=setWomensPrefence();
				HashMap<String,String> womenMatchStatus=setWomenInitialStatus();
				HashMap<String,String> menMatchStatus=setmenInitialStatus();
				
				/*	
				input 1: To get the man-woman proposal in normal order
				input 2: To get the man-woman proposal in reverse order
				input 3: To get the woman-man proposal in normal order
				input 4: Exit
				*/
				
				if(inputvalue.equals("1"))
				{
					husbandWife=callProposeAndRejectByMan(men,women,menPreference,womenPreference,menMatchStatus,womenMatchStatus);
					
					husband=husbandWife.get("husband");
					wife=husbandWife.get("wife");
					
					System.out.println("Output in Man propose woman normal order");
					printPairs(husband,men,women);
					System.out.println("husband " +Arrays.asList(husband));
					System.out.println("wife  " + Arrays.asList(wife));
				}
				
				else if(inputvalue.equals("2"))
				{
					
					husbandWife=callProposeAndRejectByManReverse(men,women,menPreference,womenPreference,menMatchStatus,womenMatchStatus);
					
					husband=husbandWife.get("husband");
					wife=husbandWife.get("wife");
					
					System.out.println("Output in Man propose woman reverse order");
					printPairs(husband,men,women);
					System.out.println("husband " + Arrays.asList(husband));
					System.out.println("wife  " + Arrays.asList(wife));
				}
				else if(inputvalue.equals("3"))
				{
					husbandWife=callProposeAndRejectByWoman(women,men,womenPreference,menPreference,womenMatchStatus,menMatchStatus);

					husband=husbandWife.get("husband");
					wife=husbandWife.get("wife");
					
					System.out.println("Output in woman propose man normal order");
					printPairs(husband,men,women);
					System.out.println("wife  " + Arrays.asList(wife));
					System.out.println("husband " + Arrays.asList(wife));
				}
				else
					{
					System.out.println("THank you");
					}
			}
		}
		 while (!inputvalue.equalsIgnoreCase("4"));
		
		
		
		
	}

	/*To 
	 * print the output pairs
	 * */
	private static void printPairs(String[] husband, List<String> men, List<String> women) {
		
		for (int i=1;i <= husband.length;i++)
		{
			System.out.println("Pair "+i+" ("+men.get(i-1)+","+women.get(Integer.parseInt(husband[i-1])-1)+")");
		}
		
	}

	/**
	 * Call and propose method for reverse list
	 * @param: proposer (Man/Woman)
	 * @param: proposed (who is being proposed - woman/men
	 * @param: proposePrefernce: preference list of the proposer)
	 * @param: womenPreference: preference list of women
	 * @param: menMatchStatus: current Match status of men
	 * @param: womenMatchStatus: current Match status of women
	 * */
	private static HashMap<String, String[]> callProposeAndRejectByManReverse(List<String> proposer, List<String> proposed,
			HashMap<String, List<String>> proposerPreference, HashMap<String, List<String>> womenPreference, HashMap<String, String> menMatchStatus, HashMap<String, String> womenMatchStatus) {
		
		String[] husband={"0","0","0","0","0"};
		String[] wife={"0","0","0","0","0"};

		
		
		while(Arrays.asList(husband).contains("0"))
		{
			int[] proposalCount={0,0,0,0,0};
			for(int i=proposer.size()-1;i>=0;i--)
			{
				String proposerName=proposer.get(i);
			
				while(husband[i]=="0")
				{
					List<String> hisPreference=proposerPreference.get(proposerName);
					
					boolean flag=true;
					for(String prospectiveMatch : hisPreference)
					{
						
						if(flag)
						{
							if(womenMatchStatus.get(prospectiveMatch).equalsIgnoreCase("UNMATCHED"))
							{
								womenMatchStatus.put(prospectiveMatch,proposerName);
								int fianceIndex=getIndex(proposed,prospectiveMatch);
								husband[i]=fianceIndex+1+"";
								wife[fianceIndex]=i+1+"";
								flag=false;
							}
							else
								if(checkPreference(prospectiveMatch,proposerName,womenPreference.get(prospectiveMatch),womenMatchStatus.get(prospectiveMatch)))
								{
									int oldFiance=getIndex(proposed,prospectiveMatch);
									int updateValue=Integer.parseInt(wife[oldFiance]);
									husband[updateValue-1]="0";
									
									womenMatchStatus.put(prospectiveMatch,proposerName);
									int fianceIndex=getIndex(proposed,prospectiveMatch);
									husband[i]=fianceIndex+1+"";
									wife[fianceIndex]=i+1+"";
									flag=false;
								}
							proposalCount[i]++;
						}
						
					}
					
				}
				
			}
		}
		
		
		HashMap<String, String[]> output=new HashMap<>();
		output.put("husband",husband);
		output.put("wife",wife);
		
		return output;
	}

	/**
	 * Call and propose method for normal list (man-woman)
	 * @param: proposer (Man/Woman)
	 * @param: proposed (who is being proposed - woman/men
	 * @param: proposePrefernce: preference list of the proposer)
	 * @param: womenPreference: preference list of women
	 * @param: menMatchStatus: current Match status of men
	 * @param: womenMatchStatus: current Match status of women
	 * */
	
	private static HashMap<String, String[]> callProposeAndRejectByMan(List<String> proposer, List<String> proposed,
			HashMap<String, List<String>> proposerPreference, HashMap<String, List<String>> womenPreference, HashMap<String, String> menMatchStatus, HashMap<String, String> womenMatchStatus) {
		
		String[] husband={"0","0","0","0","0"};
		String[] wife={"0","0","0","0","0"};

		
		
		while(Arrays.asList(husband).contains("0"))
		{
			int[] proposalCount={0,0,0,0,0};
			for(int i=0;i<proposer.size();i++)
			{
				String proposerName=proposer.get(i);
			
				while(husband[i]=="0")
				{
					List<String> hisPreference=proposerPreference.get(proposerName);
					
					boolean flag=true;
					for(String prospectiveMatch : hisPreference)
					{
						
						if(flag)
						{
							if(womenMatchStatus.get(prospectiveMatch).equalsIgnoreCase("UNMATCHED"))
							{
								womenMatchStatus.put(prospectiveMatch,proposerName);
								int fianceIndex=getIndex(proposed,prospectiveMatch);
								husband[i]=fianceIndex+1+"";
								wife[fianceIndex]=i+1+"";
								flag=false;
							}
							else
								if(checkPreference(prospectiveMatch,proposerName,womenPreference.get(prospectiveMatch),womenMatchStatus.get(prospectiveMatch)))
								{
									int oldFiance=getIndex(proposed,prospectiveMatch);
									int updateValue=Integer.parseInt(wife[oldFiance]);
									husband[updateValue-1]="0";
									
									womenMatchStatus.put(prospectiveMatch,proposerName);
									int fianceIndex=getIndex(proposed,prospectiveMatch);
									husband[i]=fianceIndex+1+"";
									wife[fianceIndex]=i+1+"";
									flag=false;
								}
							proposalCount[i]++;
						}
						
					}
					
				}
				
			}
		}
		
		
		HashMap<String, String[]> output=new HashMap<>();
		output.put("husband",husband);
		output.put("wife",wife);
		
		return output;
	}

	/**
	 * Call and propose method for woman-man
	 * @param: proposer (Man/Woman)
	 * @param: proposed (who is being proposed - woman/men
	 * @param: proposePrefernce: preference list of the proposer)
	 * @param: womenPreference: preference list of women
	 * @param: menMatchStatus: current Match status of men
	 * @param: womenMatchStatus: current Match status of women
	 * */
	
	private static HashMap<String, String[]> callProposeAndRejectByWoman(List<String> proposer, List<String> proposed,
			HashMap<String, List<String>> proposerPreference, HashMap<String, List<String>> womenPreference, HashMap<String, String> menMatchStatus, HashMap<String, String> womenMatchStatus) {
		
		String[] husband={"0","0","0","0","0"};
		String[] wife={"0","0","0","0","0"};

		
		
		while(Arrays.asList(wife).contains("0"))
		{
			int[] proposalCount={0,0,0,0,0};
			for(int i=0;i<proposer.size();i++)
			{
				String proposerName=proposer.get(i);
			
				while(wife[i]=="0")
				{
					List<String> hisPreference=proposerPreference.get(proposerName);
					
					boolean flag=true;
					for(String prospectiveMatch : hisPreference)
					{
						
						if(flag)
						{
							if(womenMatchStatus.get(prospectiveMatch).equalsIgnoreCase("UNMATCHED"))
							{
								womenMatchStatus.put(prospectiveMatch,proposerName);
								int fianceIndex=getIndex(proposed,prospectiveMatch);
								wife[i]=fianceIndex+1+"";
								husband[fianceIndex]=i+1+"";
								flag=false;
							}
							else
								if(checkPreference(prospectiveMatch,proposerName,womenPreference.get(prospectiveMatch),womenMatchStatus.get(prospectiveMatch)))
								{
									int oldFiance=getIndex(proposed,prospectiveMatch);
									int updateValue=Integer.parseInt(wife[oldFiance]);
									wife[updateValue-1]="0";
									
									womenMatchStatus.put(prospectiveMatch,proposerName);
									int fianceIndex=getIndex(proposed,prospectiveMatch);
									wife[i]=fianceIndex+1+"";
									husband[fianceIndex]=i+1+"";
									flag=false;
								}
							proposalCount[i]++;
						}
						
					}
					
				}
				
			}
		}
		
		
		HashMap<String, String[]> output=new HashMap<>();
		output.put("husband",husband);
		output.put("wife",wife);
		
		return output;
	}
	
	
	/**
	 * Get Index value to maintain husband and wife array
	 * */
	private static int getIndex(List<String> proposed, String prospectiveMatch) {
		for(int i=0;i<proposed.size();i++)
		{
			if(proposed.get(i).equalsIgnoreCase(prospectiveMatch))
				return i;
		}
		return 0;
	}
	
	/**
	 * to check the preference of the one proposed
	 * @return: boolean true if preferred to current proposer than engaged person else false
	 * */
	private static boolean checkPreference(String prospectiveMatch, String proposerName, List<String> list, String currentFiance) {
		
		int proposerValue=0;
		int currentFianceValue=0;
		for(int i=0;i<list.size();i++)
		{
			String name=list.get(i);
			if(name.equalsIgnoreCase(proposerName))
				proposerValue=i;
			else if (name.equalsIgnoreCase(currentFiance))
				currentFianceValue=i;
		
		}
		
		if(currentFianceValue>proposerValue)
		{
			return true;
		}
		else
			return false;
	}

	/**
	 * Set engagement status of Men
	 * 
	 * */
	private static HashMap<String, String> setmenInitialStatus() {
		
		HashMap<String,String> status= new HashMap<String,String>();
		status.put("Victor", "UNMATCHED");
		status.put("Wyatt", "UNMATCHED");
		status.put("Xavier", "UNMATCHED");
		status.put("Yancey", "UNMATCHED");
		status.put("Zeus", "UNMATCHED");
	
		return status;

	}
	/**
	 * Set engagement status of women
	 * */
	private static HashMap<String, String> setWomenInitialStatus() {
		HashMap<String,String> status= new HashMap<String,String>();
		status.put("Amy", "UNMATCHED");
		status.put("Bertha", "UNMATCHED");
		status.put("Clare", "UNMATCHED");
		status.put("Diane", "UNMATCHED");
		status.put("Erika", "UNMATCHED");
 	
		return status;
	}
	
	
	/**
	 * initializing mens preference
	 * */
	
	private static HashMap<String, List<String>> setMensPrefence() {
		
		HashMap<String,List<String>> preference=new HashMap<>();
		
		String[] Victor={"Bertha","Amy","Diane","Erika","Clare"};
		String[] Wyatt={"Diane","Bertha","Amy","Clare","Erika"};
		String[] Xavier={"Bertha","Erika","Clare","Diane","Amy"};
		String[] Yancey={"Amy","Diane","Clare","Bertha","Erika"};
		String[] Zeus={"Bertha","Diane","Amy","Erika","Clare"};
		
		preference.put("Victor",Arrays.asList(Victor));
		preference.put("Wyatt",Arrays.asList(Wyatt));
		preference.put("Xavier",Arrays.asList(Xavier));
		preference.put("Yancey",Arrays.asList(Yancey));
		preference.put("Zeus",Arrays.asList(Zeus));
		
		
		return preference;
	}

	/**
	 * initializing womens preference
	 * */
	private static HashMap<String, List<String>> setWomensPrefence() {
		HashMap<String,List<String>> preference=new HashMap<>();
		
		String[] Amy={"Zeus","Victor","Wyatt","Yancey","Xavier"};
		String[] Bertha={"Xavier","Wyatt","Yancey","Victor","Zeus"};
		String[] Clare={"Wyatt","Xavier","Yancey","Zeus","Victor"};
		String[] Diane={"Victor","Zeus","Yancey","Xavier","Wyatt"};
		String[] Erika={"Yancey","Wyatt","Zeus","Xavier","Victor"};
		
		preference.put("Amy",Arrays.asList(Amy));
		preference.put("Bertha",Arrays.asList(Bertha));
		preference.put("Clare",Arrays.asList(Clare));
		preference.put("Diane",Arrays.asList(Diane));
		preference.put("Erika",Arrays.asList(Erika));
		
		
		return preference;
	}

	/**
	 * initializing men
	 * */
	private static List<String> populateWomen() {
		String[] womens={"Amy","Bertha","Clare","Diane","Erika"};
		
		return Arrays.asList(womens);
	}
	
	/**
	 * initializing women
	 * */
	private static List<String> populateMen() 
	{
		String[] mens={"Victor","Wyatt","Xavier","Yancey","Zeus"};
		
		return Arrays.asList(mens);
	}
}
