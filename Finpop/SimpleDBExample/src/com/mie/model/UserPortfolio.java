package com.mie.model;

		/* ---------------------------------USER PORTFOLIO-----------------------------------*/
	
	/* This class stores User Portfolio information of the company name, number of shares, stock price and total money invested to be 
	displayed onto each user's portfolio for each company. */

public class UserPortfolio {
	
	// Every attribute gets an element
	private String compName;
	private int numShares;
	private double stockPrice;
	private double totalMoney;
	
	// Initiatlizes the User Portfolio class
	public UserPortfolio(){
		this.compName = "";
		this.numShares = -1;
		this.stockPrice = -1;
		this.totalMoney = -1;
	}

	// Sets user portfolio class with input variables required for the user portfolio to be displayed on FinPOP
	public UserPortfolio(String compName, int numShares, double stockPrice, double totalMoney){
		this.setCompName(compName);
		this.setNumShares(numShares);
		this.setStockPrice(stockPrice);
		this.setTotalMoney(totalMoney);
	}
	
	// Returns company name 
	public String getCompName(){
		return this.compName;
	}
	
	// Sets company name 
	public void setCompName(String s){
		this.compName = s;
	}
	
	// Returns number of shares
	public int getNumShares(){
		return this.numShares;
	}
	
	// Set number of shares purchased by user 
	public void setNumShares(int n){
		this.numShares = n;
	}
	
	// Returns stock price (updated quarterly for now) of company 
	public double getStockPrice(){
		return this.stockPrice;
	}
	
	// Sets stock price (updated quarterly for now) of company
	public void setStockPrice(double d){
		this.stockPrice = d;
	}
	
	// Returns total money invested by user on company
	public double getTotalMoney(){
		return this.totalMoney;
	}
	
	// Sets total money invested by user on company based on # of shares and price/share
	public void setTotalMoney(double d){
		this.totalMoney = d;
	}
	
	

}
