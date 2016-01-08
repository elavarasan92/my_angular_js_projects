package com.ela.csvtopojo;



public class infoTable { 
	 
	private String nameOfIssuer;
	private String titleOfClass;
	private String cusip;
	private int value;
	private ShrsOrPrnAmt shrsOrPrnAmt;
	private String putCall;
	private String investmentDiscretion;
	private int otherManager;
	private VotingAuthority votingAuthority;
	
	
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	
	public int getOtherManager() {
		return otherManager;
	}
	public void setOtherManager(int otherManager) {
		this.otherManager = otherManager;
	}
	public String getNameOfIssuer() {
		return nameOfIssuer;
	}
	public void setNameOfIssuer(String nameOfIssuer) {
		this.nameOfIssuer = nameOfIssuer;
	}
	public String getTitleOfClass() {
		return titleOfClass;
	}
	public void setTitleOfClass(String titleOfClass) {
		this.titleOfClass = titleOfClass;
	}
	public String getCusip() {
		return cusip;
	}
	public void setCusip(String cusip) {
		this.cusip = cusip;
	}
	
	
	
	public String getPutCall() {
		return putCall;
	}
	public void setPutCall(String putCall) {
		this.putCall = putCall;
	}
	public String getInvestmentDiscretion() {
		return investmentDiscretion;
	}
	public void setInvestmentDiscretion(String investmentDiscretion) {
		this.investmentDiscretion = investmentDiscretion;
	}
	

	public VotingAuthority getVotingAuthority() {
		return votingAuthority;
	}
	public void setVotingAuthority(VotingAuthority votingAuthority) {
		this.votingAuthority = votingAuthority;
	}
	public ShrsOrPrnAmt getShrsOrPrnAmt() {
		return shrsOrPrnAmt;
	}
	public void setShrsOrPrnAmt(ShrsOrPrnAmt shrsOrPrnAmt) {
		this.shrsOrPrnAmt = shrsOrPrnAmt;
	}
	
	
	
	

}

