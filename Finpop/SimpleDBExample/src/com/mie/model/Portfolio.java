package com.mie.model;

		/* ---------------------------------PORTFOLIO-----------------------------------*/
	
	/* This class stores Portfolio information of the username, company name, ticker and number of shares. */

public class Portfolio {

	// Every attribute gets an element
	private String username;
	private String compName;
	private String ticker;
	private int numShares;
	
	// Initializes the Portfolio class 
	public Portfolio(){
		this.username = "";
		this.compName = "";
		this.ticker = "";
		this.numShares = -1;
	}
	
	// Sets portfolio class with input variables required for the portfolio to be displayed on FinPOP
	public Portfolio(String username, String compName, String ticker, int numShares){
		this.setCompName(compName);
		this.setNumShares(numShares);
		this.setTicker(ticker);
		this.setUsername(username);
	}
	
	// Returns username corresponding to Portfolio
	public String getUsername(){
		return this.username;
	}
	
	// Sets username corresponding to Portfolio 
	public void setUsername(String s){
		this.username = s;
	}
	
	// Returns name of company invested by user
	public String getCompName(){
		return this.compName;
	}
	
	// Sets name of company invested by user
	public void setCompName(String s){
		this.compName = s;
	}
	
	// Returns ticker of company invested by user
	public String getTicker(){
		return this.ticker;
	}
	
	// Sets ticker of company invested by user
	public void setTicker(String s){
		this.ticker = s;
	}
	
	// Returns number of shares the user has invested in the company 
	public int getNumShares(){
		return this.numShares;
	}
	
	// Sets number of shares the user has invested in the company to update from portfolio page
	public void setNumShares(int n){
		this.numShares = n;
	}
	
}
