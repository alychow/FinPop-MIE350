package com.mie.model;

		/* ---------------------------------INVESTS IN-----------------------------------*/
	
	/* This class stores InvestsIn information of the company name, ticker and shares owned by user. This class is used
	for when FinPOP displays which companies are invested by a selected hedgefund. */

public class InvestsIn {

	// Every attribute gets an element	
	private String companyName;
	private String ticker;
	private int sharesOwned;
	
	// Initializes the InvestsIn class 
	public InvestsIn(){
		this.companyName = "";
		this.ticker = "";
		this.sharesOwned = -1;
	}
	
	// Returns the company name 
	public String getCompanyName(){
		return this.companyName;
	}
	
	// Sets the company name 
	public void setCompanyName(String s){
		this.companyName = s;
	}
	
	// Returns the ticker  
	public String getTicker(){
		return this.ticker;
	}
	
	// Sets the ticker  
	public void setTicker(String s){
		this.ticker = s;
	}
	
	// Returns the shares owned by user
	public int getSharesOwned(){
		return this.sharesOwned;
	}
	
	// Sets the shares owned by user  
	public void setSharesOwned(int n){
		this.sharesOwned = n;
	}
	
}
