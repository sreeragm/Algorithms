package com.umassd.bioinfo;

public class Output implements Comparable<Output>{

	private String kmer;
	
	private Double probab;

	public Double getProbab() {
		return probab;
	}

	public void setProbab(Double probab) {
		this.probab = probab;
	}

	public String getKmer() {
		return kmer;
	}

	public void setKmer(String kmer) {
		this.kmer = kmer;
	}
	
	@Override
	public int compareTo(Output o2) {
		// TODO Auto-generated method stub
		
		double val1 = this.getProbab();
		double val2 = o2.getProbab();
		
		if(val1 > val2)
			return -2;
		else
			 return 1;
	}
	
	
}
