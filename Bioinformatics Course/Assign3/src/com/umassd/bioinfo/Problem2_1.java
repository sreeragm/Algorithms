package com.umassd.bioinfo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sreerag
 * @desc: Assign 3 bioinform Implment Greedy motif problem
 * @param: kmersize, no of strings, inputdna
 * @output: collection of best motifs
 */ 
public class Problem2_1 {

	static List<Output> outputs = new ArrayList<>();
	public static void main(String[] args) throws IOException {
	
		int kmersize = 12;
	
		int noofStrings = 25;
		
		
		String [] inputdna = {"GCGTGCCTTACGAGGTTCCGGCCTTTAAGAGAGGATGATTGGGGGACTCCTTTGCAGACTTTACCCACACGGCGGGACAGTCTTAAGCGGTTTATCTCCCAACGATTGTCAGTGTTAGACTTCCCTAATGGGGAATTATTGATTATATATGGATGA",
				"AAACTGATTCATATTGCCGCGTAGCCTTAATATGTCACTCAACTCCTTACAAGATATGACGTTTATATCATGCTCGAGGGGTTCCCAGACGATCTTCTCAGGTCGGCTAGAAGAATCTTTCGTATTTTTTCGCAGGCGGTTCACAGAGTACGGAAG",
				"AACACTAGATGGGCAGATTGCCTGCTAACTTTAAATACATACTTTCAAGCGCTCGTCGCGCTACTGAGCGTTAATTTCGTTTAGAGGCATGTGAATCGGGAAATCTTTAATCCGGCTTATTTTTTTAGGCGCGAGATGCTACACCATGACACTCTT",
				"CTTCGCCGCAATGTATAGAAATCCGATCGTACGGCCACCGTGGGAGCCTTAGATACGCGCCCACGTCGTCTCTCTCCCACGCCCCATATACTAAAGTCTCTCCTATTCGCTCGCAGGTGGGGAGATTCAGTGAGCCCGTCACAGCTAGACCCTCTT",
				"ACACATATACCGTGCATGAACCTGCAGGACTATCTTCCGTCAACCTCAGGGTCACCTGCTTCTGATGTATTGAATATTTAACTCTAGTGATATAGTGTCCGTGATGACCATTACCTGTGCTTCCTTCGTCTCTTCGCGGTGGGTTCTCGCAAAAAC",
				"CGTGAAACCATCTGAAGTGAGATTCCCAGTTACCGCTGTCAAAAGCTCATACGCCTTAGTGATACACCCAGTTGTCTTAGAAACACATAAGGAACACGTAGATAAGTTGATCTCCCACGAGCTATCTCGTAGCCCGACCATCTTGTATGCATATGG",
				"CTATACCAGGGAGGATACACCCCTTACAAGTGTTTCTTCACAGTGTATACGGAAAATGGGCGGACAAAACGATATAACGGGTACGACACAGGCAGTAGCTGGTAAGGCCCGGACCCCGCAACCGAACCCTACCACGACCTTCTTTCGGCTAGAACA",
				"CTTATGTCTTTGTCCATCGAAGACTAGACATAGTAATGCCCTGATGGAGAGACTTTGGGGTACGGACCGATGCCGGACTATCTTGGTCAACACCCGCACTCGGGGTACGATATGTATATACACAGACTAGCATCACTCGCAGTGGGGCTTAAAAAC",
				"CTAATCTTTTTGACCTATGACGCTCTCCTCCTGCAAAACCAATTCAACGTTAGAGCGTTTTTTGGGTATGGGAAGCCTATAGGTACGGAATCCTAGTACATTGGCGATATAAAAGTCATCTATATGCGGATTGTTTGCAGTTTCCTTGACCCTCTT",
				"CAGCAAATTCTCGGCCCGCCAGCCATTGAAGAGTCTCTTGACCGTCTTCCTATTAAAGACTACCCGATAGTCTGATGTCTTATGCGCGACCCGCACGTTGTAGATTACCGTTTGGAAGTCGGGTTGGTCACACCAGTGGGCTTGGAAAACTCTTCA",
				"TCCTCGTGGGCCTCCTTCAGTGGTGTCGCCTAAAAGTCCCTTTCTTTTAAGTGTAGTAATGACCCTCGCCCACTATACAAACCAACCGTGCGTGAGAATTCCTAGGCAGATTTTGTCCTACGGGACACTCTTGCTGACGAACGACCAAAGAAGGGT",
				"GGCGAGATACCTCGGAGAGGCGGGTGTTGGTATCGAATCTAGCTGCTTGCTTAGCCGGCGCCGGACGGTCTTAAGCTCTAGGATTGTGACATGGGGCGCTCCCTCCTATCTCCTCGTTAATTCCGGGCGCAACGATCACACGCACACACCAACTGA",
				"CCGTTCTAGTCCCGAACCCCGGGTTTCACCAGCTCCATAAACCAACCAAGTGGCTTATCCCTCAGGAAGTGACAGTTAAGACGATTGTCATGTTGACAGGACCCTCTTGCCGCTTTTCACGACGGCGGGTTGATAAGATAGAATCGCGTAGAAACC",
				"CGTCGAGCATCCATTCGTAGGTCAAATCGACCACCAATGTTGTCTCTGGTAAGGCACGGGGTTACTCATAACCGCACAATTTGACCCACGAGGAGTCCCACGGGCACAAACCGGCTAAGGGCCATTGGGAACCTTGACGCTCTTCATTATGTGGCC",
				"GGTCGGGATGGGACCAGAGTTGGCTGCAGAGTAACTCTGTTCATGGCTTGGGGCTTGCTGCGAGACCTTCTTACGTTTTATGTGTGAACGAGCGGACCGAGGTCGGCGATTGATGGCGGGGACGTCTAAGCGACCCTGTAACCAGTAACGAAACTC",
				"ACTACATATGCTAGCGATCAACGAGCGCACCTAAATAAGTCCACTCAGCGCACCTGACTAGAGCTTTCAGACGACCCTCAGGAGATTTAAAAATGGGTGATATGTCGAAAATTTGACGGTTAGGGCTTCATACATGACACTCTTCCAGCAGTTTAT",
				"CGTGGTTGTCCCGAACCTTTGTCATGGGGTGGGGCGCCAGACGGTCTTCAACCCATGGATCGTGCGGGCAAGAAGTAAGTAGATAGGTAGGTATGCTTCTGACTTTTAGTCAAACACAACTTTGTTCTAAGCCCCTTTAGCCGATATCTTCGGGTT",
				"CCCGACGATCTTCGCGTCAATAGTTATTTGAGGTTCCTCACCCTTTCAAATTGTCTCTGTGAGGACGCTACAACTTCATCTTCTAGCAAGACAGGGCTTAAGCTGGAGATCAGAAGGGCCTGTGTATCACGATGGGATGCCGTCGAGGCAAGCGTA",
				"GATTTGATCGGGGTCGGCAACTGGGGTGAGTTAGGGCACCAACTTACTACTAGTTGTAGGCGTTGTGCTCTCGATGTCAGCTGCGTTCCAGTTTCTACGGCGTCTGAGCGTGGCTAAATGAAACTTAATGGCCCGGACGATCTTCCTTTGGCTTGG",
				"ACGGAGACGCTTGTCTCCTCGTTCTTCAGTAACACATAGGCGACAATAATAGTACTACACAGCGTATTGGTTCTTGACACTCTTGTAACGTGACACCCCACGGCTGTTACTCGTTACATTGCAACAAACTGGACCGGGGACTTCTGCCCTCTCACA",
				"GCCATCCGACACTAATAACAGTATGAGCCGGTTAGAGTAGTCATGTGCGAGGTATGATCGCCGTCGACACCTACCGTGCTCTCGTGGGCTAGTAGGAGATCATTCTTTCCTTTCCCGGTTCCCGACCATCTTATGTTGGGAGTTGGCTAATGCTAG",
				"GATTTCTCGATCCCGGTGAGCGCCGTAAGAATCCCTCGTGACATTCTTGATAACTTCTTTCCATCTACATGTGCAACCGCGTGCGAGAGGCCGAGCCCTCTTACGTGGAATAATGTCGGAAGTCCGTGGCTTCACTCGCTGCACTTGAAGAACACG",
				"CTGAAGATACATCATCCGCTTCGACAGTTCGGGGGACCGTTCCTCACCGCCTTACAGATTACATATATGATGTCGCAAACTGCTCTTGACCATCTTGTATCTATAGGGACGAGACATCTACAGAACATGAGGCTCCCTCTGTTGGCAAGGAAGTCA",
				"ACACAGGGAGGAAGAGACGAGAGACTGGACGCTCTTGTGAATGACGGCTGTGGACGTAATGCAGGATCCGACGAGTCACCGCACGACGGGTCACCGTGGCTAGTTCTCGTGGACGAAGTGAATGATTACTGCCAAACGCAGCCAGGTTCTACTCTT",
				"ACTAATTAATCACTTGACCTTCTTAGCTGCCTTGTGGGTGTCGGGGGGTAAATCTTCGTCAAATGGCAACGGAGGTTGTTAGGCGTACGCTGCAATCCACCGGCTTTATTTGCTACGCCGACGCACAATCGTATCCGAAACGTAGGTATTGAAATC"};

		char [] alphabet = {'A', 'C', 'G', 'T'};
	
		// method to generate bestmotifs
		findGreedyMotif(inputdna, alphabet,kmersize,noofStrings);

		
	}

	private static void findGreedyMotif(String[] inputdna, char[] alphabet, int kmersize, int noofStrings) {
		// TODO Auto-generated method stub
		
		List<OutputVO> outputVOs = new ArrayList<>();
		char[] initchararray = inputdna[0].toCharArray();

		
		// Loopings through the kmers of first string
		for (int i = 0 ; i < (initchararray.length - kmersize + 1) ; i++)
		{
			
			char[] ithKmer = new char[kmersize];		
			for (int j = 0 ; j < kmersize ; j++)
			{
				ithKmer[j] = initchararray[i+j];
			}
		
			// initial Profile Matrix
			double[][] initialProbabMatrix = initStringMatrix(kmersize, ithKmer);
			

			OutputVO outputVO = new OutputVO();
			List<char[]> forEachDNA = new ArrayList<>();
			Map<String,Integer> kmerCount = new HashMap<>();
			forEachDNA.add(ithKmer);
			

			char[] Kmer = null;
			List<char[]> kmerdna = new ArrayList<>();
			
			kmerdna.add(ithKmer);
			kmerCount.put(new String(ithKmer), 1);
			// loop through and compare 2 to last dna strings
			
			for( int j = 1 ; j < inputdna.length ; j++)
			{
				char[] jthDnaKmer = inputdna[j].toCharArray();
				
				char[] bestkmerString = null;
				double score = 0;
				double bestscore = -1;
				
				for (int k = 0 ; k < (jthDnaKmer.length - kmersize + 1) ; k++)
				{
					
					Kmer = new char[kmersize];	
					for (int k1 = 0 ; k1 < kmersize ; k1++)
					{
						Kmer[k1] = jthDnaKmer[k+k1];
						
						
					}
					score = getScore(initialProbabMatrix, Kmer);
					
					if(score > bestscore)
					{
						bestscore = score;
						bestkmerString = Kmer;
					}
				}
				
				if(!kmerCount.containsKey(new String(bestkmerString)))
				{
					kmerCount.put(new String(bestkmerString), 1);
				}
				else
				{
					int count = kmerCount.get(new String(bestkmerString));
					count++;
					kmerCount.put(new String(bestkmerString), count);
				}
				
				
				forEachDNA.add(bestkmerString);
				

				//initialProbabMatrix = updateInitialMatrix(initialProbabMatrix, bestkmerString, j+1);
				kmerdna.add(bestkmerString);
				initialProbabMatrix = implementGreedyMotif(kmersize, j+1, kmerdna);
			}
			
			outputVO.setKmers(forEachDNA);
			
			double bestmismatchscore = 99999;
			
			
			bestmismatchscore = calculateMismatchScore(kmerdna,kmersize);
			outputVO.setScore(bestmismatchscore);
			
			outputVOs.add(outputVO);

			
		}
		
	
		
		int findIndex = 0;
		double bestScore = 999999;
		double score;
		for (int i = 0 ; i < outputVOs.size(); i++)
			{
			score = outputVOs.get(i).getScore();
			if(score < bestScore)
			{
				 bestScore = score;
				findIndex = i;
			}

			}
		
		List<char[]> bestkmers = outputVOs.get(findIndex).getKmers();
		
		for (char [] val : bestkmers)
			{
			System.out.println(new String(val));
			}
		
		
	}
	

private static double calculateMismatchScore(List<char[]> kmerdna, int kmersize) {
		// TODO Auto-generated method stub
		
	
	double mismatchCounter = 0;
	for (int i = 0 ; i < kmersize ; i++)
	{
		int countA = 0;
		int countC = 0;
		int countG = 0;
		int countT = 0;
		
		List<Integer> list = new ArrayList<>();
		int maxcount = 0;
		for ( int j = 0 ; j < kmerdna.size() ; j++)
		{
			if(kmerdna.get(j)[i]=='A')
			{
				countA++;
			}
			else
				if(kmerdna.get(j)[i]=='C')
				{
					countC++;
				}
				else
					if(kmerdna.get(j)[i]=='G')
					{
						countG++;
					}
					else
						if(kmerdna.get(j)[i]=='T')
						{
							countT++;
						}
		}
		
		list.add(countA);
		list.add(countC);
		list.add(countG);
		list.add(countT);
		
		Collections.sort(list);
		maxcount = list.get(3);
		mismatchCounter = mismatchCounter + ((kmersize-1) - maxcount);
	}
	
	return mismatchCounter;
	}

/**
 * 
 * @param initialProbabMatrix
 * @desc: finding the score
 * @param kmer
 * @return score
 * 
 */
	private static double getScore(double[][] initialProbabMatrix, char[] kmer) {
		// TODO Auto-generated method stub
		
		double score = 1;
		for ( int i = 0 ; i < kmer.length ; i++)
		{
			switch (kmer[i]) {
			case 'A':
				{
					score = score * initialProbabMatrix[0][i];
					break;	
				}

			case 'C':
				{
					score = score * initialProbabMatrix[1][i];
					break;	
				}

			case 'G':
			{
				score = score * initialProbabMatrix[2][i];
				break;	
			}
			
			case 'T':
			{
				score = score * initialProbabMatrix[3][i];
				break;	
			}
			
			default:
				break;
			}
		};
		
		return score;
	}

	
/**
 * 
 * @param kmersize
 * @desc: find the initial profile matrix
 * @param inputCharArr
 * @return
 */
	private static double[][] initStringMatrix(int kmersize, char[] inputCharArr) {
		

		double probabMatrix[][] = new double[4][kmersize];
		
		
		double initprobab = 1;
	//	System.out.println(countmatrix);
		
		for ( int i = 0 ; i < kmersize; i++)
		{
			
			if(inputCharArr[i] == 'A')
			{
				probabMatrix[0][i] = initprobab;
				probabMatrix[1][i] = 0;
				probabMatrix[2][i] = 0;
				probabMatrix[3][i] = 0;
			}
			else
				if(inputCharArr[i] == 'C')
				{
					probabMatrix[1][i] = initprobab;
					probabMatrix[0][i] = 0;
					probabMatrix[2][i] = 0;
					probabMatrix[3][i] = 0;
				}
				else
					if(inputCharArr[i] == 'G')
					{
						probabMatrix[2][i] = initprobab;
						probabMatrix[1][i] = 0;
						probabMatrix[0][i] = 0;
						probabMatrix[3][i] = 0;
					}
					else
						if(inputCharArr[i] == 'T')
						{
							probabMatrix[3][i] = initprobab;
							probabMatrix[1][i] = 0;
							probabMatrix[2][i] = 0;
							probabMatrix[0][i] = 0;
						}
						
		}
		
		//System.out.println(probabMatrix);
		
		return probabMatrix;
		
	
	}
	
	/**
	 *@method: implementGreedyMotif 
	 * @param kmersize
	 * @param noofStrings
	 * @param kmerdna
	 * @return
	 */
	private static double[][] implementGreedyMotif(int kmersize, int noofStrings, List<char[]> kmerdna) {
		// TODO Auto-generated method stub
		
		double probabMatrix[][] = new double[4][kmersize];
		
		char countmatrix[][] = new char[noofStrings][] ;
		
		for ( int i = 0 ; i < noofStrings ; i++)
		{
			countmatrix[i] = kmerdna.get(i);
		}
		
	//	System.out.println(countmatrix);
		
		for ( int i = 0 ; i < kmersize ; i++)
		{
			int k = 0;
			double countA = 0;
			double countC = 0;
			double countG = 0;
			double countT = 0;
			
			for ( int j = 0 ; j < noofStrings ; j++)
			{
				if(countmatrix[j][i] == 'A')
					countA++;
				else
					if(countmatrix[j][i] == 'C')
						countC++;
					else
						if(countmatrix[j][i] == 'G')
							countG++;
						else
							if(countmatrix[j][i] == 'T')
								countT++;
							
			}
			
			//System.out.println(countA/noofStrings);
			probabMatrix[k][i] = countA/noofStrings;
			k++;
			//System.out.println(countC/noofStrings);
			probabMatrix[k][i] = countC/noofStrings;
			k++;
			//System.out.println(countG/noofStrings);
			probabMatrix[k][i] = countG/noofStrings;
			k++;
			//System.out.println(countT/noofStrings);
			probabMatrix[k][i] = countT/noofStrings;
			
			
			/*for ( int j = 0 ; j < noofStrings ; j++)
			{
				probabMatrix[i][]
				
			}*/
		}
		
		
		
		return probabMatrix;
		
	}
	


	
}
