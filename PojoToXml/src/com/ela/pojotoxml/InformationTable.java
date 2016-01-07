package com.ela.pojotoxml;

public class InformationTable { 
	 
	private String nameOfIssuer;
	private String titleOfClass;
	private String cusip;
	private int value;
	private int sshPrnamt;
	private String sshPrnamtType;
	private String putCall;
	private String investmentDiscretion;
	private int otherManager;
	private Voting voting;
	
	
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public int getSshPrnamt() {
		return sshPrnamt;
	}
	public void setSshPrnamt(int sshPrnamt) {
		this.sshPrnamt = sshPrnamt;
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
	
	
	public String getSshPrnamtType() {
		return sshPrnamtType;
	}
	public void setSshPrnamtType(String sshPrnamtType) {
		this.sshPrnamtType = sshPrnamtType;
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
	
	public Voting getVoting() {
		return voting;
	}
	public void setVoting(Voting voting) {
		this.voting = voting;
	}
	@Override
	public String toString() {
		return "InformationTable [nameOfIssuer=" + nameOfIssuer + ", titleOfClass=" + titleOfClass + ", cusip=" + cusip
				+ ", value=" + value + ", sshPrnamt=" + sshPrnamt + ", sshPrnamtType=" + sshPrnamtType + ", putCall="
				+ putCall + ", investmentDiscretion=" + investmentDiscretion + ", otherManager=" + otherManager
				+ ", voting=" + voting + "]";
	}
	
	
	
	

}
