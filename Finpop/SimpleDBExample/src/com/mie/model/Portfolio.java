package com.mie.model;

public class Portfolio {

	//Every attribute gets an element
	private int userID;
	private String compName;
	private String ticker;
	private int numShares;
	
	public Portfolio(){
		this.userID = -1;
		this.compName = "";
		this.ticker = "";
		this.numShares = -1;
	}
	
	public Portfolio(int userID, String compName, String ticker, int numShares){
		this.setCompName(compName);
		this.setNumShares(numShares);
		this.setTicker(ticker);
		this.setUserID(userID);
	}
	
	public int getUserID(){
		return this.userID;
	}
	
	public void setUserID(int n){
		this.userID = n;
	}
	
	public String getCompName(){
		return this.compName;
	}
	
	public void setCompName(String s){
		this.compName = s;
	}
	
	public String getTicker(){
		return this.ticker;
	}
	
	public void setTicker(String s){
		this.ticker = s;
	}
	
	public int getNumShares(){
		return this.numShares;
	}
	
	public void setNumShares(int n){
		this.numShares = n;
	}
	
}
