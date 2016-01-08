package com.ela.csvtopojo;

public class VotingAuthority {
	
	private int sole;
	private int shared;
	private int none;
	
	
	public int getSole() {
		return sole;
	}
	public void setSole(int sole) {
		this.sole = sole;
	}
	public int getShared() {
		return shared;
	}
	public void setShared(int shared) {
		this.shared = shared;
	}
	public int getNone() {
		return none;
	}
	public void setNone(int none) {
		this.none = none;
	}
	
	
	@Override
	public String toString() {
		return "Voting [sole=" + sole + ", shared=" + shared + ", none=" + none + "]";
	}
	
	
	
	

}

