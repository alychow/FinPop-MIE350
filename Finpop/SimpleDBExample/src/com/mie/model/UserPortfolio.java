package com.mie.model;

public class UserPortfolio {
	
	private String compName;
	private int numShares;
	private double stockPrice;
	private double totalMoney;
	
	public UserPortfolio(){
		this.compName = "";
		this.numShares = -1;
		this.stockPrice = -1;
		this.totalMoney = -1;
	}
	
	public UserPortfolio(String compName, int numShares, double stockPrice, double totalMoney){
		this.setCompName(compName);
		this.setNumShares(numShares);
		this.setStockPrice(stockPrice);
		this.setTotalMoney(totalMoney);
	}
	
	public String getCompName(){
		return this.compName;
	}
	public void setCompName(String s){
		this.compName = s;
	}
	
	public int getNumShares(){
		return this.numShares;
	}
	
	public void setNumShares(int n){
		this.numShares = n;
	}
	
	public double getStockPrice(){
		return this.stockPrice;
	}
	
	public void setStockPrice(double d){
		this.stockPrice = d;
	}
	
	public double getTotalMoney(){
		return this.totalMoney;
	}
	
	public void setTotalMoney(double d){
		this.totalMoney = d;
	}
	
	

}
