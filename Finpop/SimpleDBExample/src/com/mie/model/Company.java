package com.mie.model;
import java.util.ArrayList;

import com.mie.dao.*;

		/* ---------------------------------COMPANY-----------------------------------*/
	
	/* This class stores Company information of the name, ticker, headquarter nation, stock price (every quarter), description and logo URL to be 
	displayed onto each Company's profile when selected from the user's portfolio or in search results. */

public class Company {

	// Every attribute gets an element
	private String compName;
	private String ticker;
	private String nation;
	private double stockPrice;
	private String desc;
	private String logoURL;
	
	// Initializes new query from Query class
	private Query dao = new Query();
	
	// Initializes the Company class 
	public Company(){
		this.compName = "";
		this.ticker = "";
		this.nation = "";
		this.stockPrice = -1;
		this.desc = "";
	}
	
	// Sets company class with input variables required for the company to be displayed on FinPOP
	public Company(String compName, String tick, String nation, double price, String desc){
		this.compName = compName;
		this.ticker = tick;
		this.nation = nation;
		this.stockPrice = price;
		this.desc = desc;
	}
	
	// Returns the company name 
	public String getCompName(){
		return this.compName;
	}
	
	// Sets company name
	public void setCompName(String s){
		this.compName = s;
	}
	
	// Returns company logo URL 
	public String getLogoURL(){
		return this.logoURL;
	}
	
	// Sets company logo URL to be displayed in company profile
	public void setLogoURL(String s){
		this.logoURL = s;
	}
	
	// Returns company ticker
	public String getTicker(){
		return this.ticker;
	}
	
	// Sets company ticker
	public void setTicker(String s){
		this.ticker = s;
	}
	
	// Returns the company headquarter city 
	public String getNation(){
		return this.nation;
	}
	
	// Sets the company headquarter city 
	public void setNation(String s){
		this.nation = s;
	}
	
	// Returns the company stock price (per quarter for now)
	public double getStockPrice(){
		return this.stockPrice;
	}
	
	// Sets the company stock price (per quarter for now) 
	public void setStockPrice(double s){
		this.stockPrice = s;
	}
	
	// Returns company description 
	public String getDesc(){
		return this.desc;
	}
	
	// Sets company description 
	public void setDesc(String s){
		this.desc = s;
	}
	
	// Returns hedge funds invested in the current company 
	public ArrayList<Hedgefund> getHedgeInvested(){
		return dao.selectCompHedgeList(this.compName);
	}
	
}
