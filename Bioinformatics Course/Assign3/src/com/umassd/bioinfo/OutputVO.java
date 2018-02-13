package com.umassd.bioinfo;

import java.util.List;
import java.util.Map;

public class OutputVO implements Comparable<OutputVO>{

	private List<char[]> kmers;
	
	private Map<char[],Integer> kmerCount;

	private double score;


	public Map<char[], Integer> getKmerCount() {
		return kmerCount;
	}

	public void setKmerCount(Map<char[], Integer> kmerCount) {
		this.kmerCount = kmerCount;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public List<char[]> getKmers() {
		return kmers;
	}

	public void setKmers(List<char[]> kmers) {
		this.kmers = kmers;
	}

	@Override
	public int compareTo(OutputVO o2) {
		// TODO Auto-generated method stub
		
		double val1 = this.getScore();
		double val2 = o2.getScore();
		
		if(val1 > val2)
			return 2;
		else
			 return -1;
	}
	
	
}
