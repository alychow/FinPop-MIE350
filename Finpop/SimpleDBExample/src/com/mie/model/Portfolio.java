package com.mie.model;

public class Portfolio {

	//Every attribute gets an element
	private String username;
	private String compName;
	private String ticker;
	private int numShares;
	
	public Portfolio(){
		this.username = "";
		this.compName = "";
		this.ticker = "";
		this.numShares = -1;
	}
	
	public Portfolio(String username, String compName, String ticker, int numShares){
		this.setCompName(compName);
		this.setNumShares(numShares);
		this.setTicker(ticker);
		this.setUsername(username);
	}
	
	public String getUsername(){
		return this.username;
	}
	
	public void setUsername(String s){
		this.username = s;
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
