package com.mie.model;

public class InvestsIn {

	private String companyName;
	private String ticker;
	private int sharesOwned;
	
	public InvestsIn(){
		this.companyName = "";
		this.ticker = "";
		this.sharesOwned = -1;
	}
	
	public String getCompanyName(){
		return this.companyName;
	}
	
	public void setCompanyName(String s){
		this.companyName = s;
	}
	
	public String getTicker(){
		return this.ticker;
	}
	
	public void setTicker(String s){
		this.ticker = s;
	}
	
	public int getSharesOwned(){
		return this.sharesOwned;
	}
	
	public void setSharesOwned(int n){
		this.sharesOwned = n;
	}
	
}
