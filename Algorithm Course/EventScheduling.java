

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class EventScheduling {

	
	public static void main(String[] args) throws IOException 
	{
		System.out.println("Enter number of Contestants: ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String inputvalue=br.readLine();
		
		if(!isEmpty(inputvalue) && checkNumber(inputvalue))
		{
			int input=Integer.parseInt(inputvalue);
			List<Contestant> contestantList=new ArrayList<>();
			for(int i=0;i<input;i++)
			{
				String swimmingtime;
				String cyclingtime;
				String runningtime;
				do
				{
					System.out.println("Enter Valid Swimming timing of "+(i+1)+" contestant");
					swimmingtime=br.readLine();
					System.out.println("Enter Valid Biking timing of "+(i+1)+" contestant");
					cyclingtime=br.readLine();
					System.out.println("Enter Valid Running timing of "+(i+1)+" contestant");
					runningtime=br.readLine();
				}
				while(!((!isEmpty(swimmingtime) && checkNumber(swimmingtime)) && (!isEmpty(cyclingtime) && checkNumber(cyclingtime)) && (!isEmpty(runningtime) && checkNumber(runningtime))));
				
				Contestant contestant=new Contestant();
				contestant.setSwimmingtime(Double.parseDouble(swimmingtime));
				contestant.setCyclingtime(Double.parseDouble(cyclingtime));
				contestant.setRunningtime(Double.parseDouble(runningtime));
				
				contestant.setTotaltime(Double.parseDouble(swimmingtime)+Double.parseDouble(cyclingtime)+Double.parseDouble(runningtime));
				contestantList.add(contestant);
			}
			
			contestantList.sort(Comparator.comparing(Contestant::getSwimmingtime));
			

			double startime=0;
			double endtime=0;
			
			double maxCompletiontime=0;
			for(Contestant contestant:contestantList)
			{
				contestant.setStarttime(startime);
				startime=startime+contestant.getSwimmingtime();
				
				endtime=contestant.getStarttime()+contestant.getTotaltime();
				contestant.setEndtime(endtime);
				
				if(contestant.getEndtime()>maxCompletiontime)
				{
					maxCompletiontime=contestant.getEndtime();
				}
				System.out.println("Swimming  timings :"+ contestant.getSwimmingtime()+" Biking time "+contestant.getCyclingtime()+" running time "+contestant.getRunningtime()+" Starttime time "+contestant.getStarttime()+" Endtime time "+contestant.getEndtime()+" Total time "+contestant.getTotaltime());
			}
			
			System.out.println("Minimum time required to finish the entire triathlon for "+inputvalue+" contestants is : "+maxCompletiontime);
		}
	
	}

	private static boolean checkNumber(String inputvalue) {
		char[] number = inputvalue.toCharArray();
		for(int i=0;i<number.length;i++){
			if(!(number[i]=='1' || number[i]=='2' || number[i]=='3' || number[i]=='4' || number[i]=='5' || number[i]=='6' || number[i]=='7' || number[i]=='8' || number[i]=='9' || number[i]=='0'))
				return false;
		}
		return true;
	}

	private static boolean isEmpty(String inputvalue) {
		
		if(inputvalue!=null && !inputvalue.isEmpty())
		{
			return false;
		}
		else
			return true;
	}

	
}
