package com.mie.model;
import java.util.ArrayList;

import com.mie.dao.*;

public class Company {

	//Every attribute gets an element
	private String compName;
	private String ticker;
	private String nation;
	private double stockPrice;
	private String desc;
	private String logoURL;

	private Query dao = new Query();
	
	public Company(){
		this.compName = "";
		this.ticker = "";
		this.nation = "";
		this.stockPrice = -1;
		this.desc = "";
	}
	
	public Company(String compName, String tick, String nation, double price, String desc){
		this.compName = compName;
		this.ticker = tick;
		this.nation = nation;
		this.stockPrice = price;
		this.desc = desc;
	}
	
	public String getCompName(){
		return this.compName;
	}
	
	public void setCompName(String s){
		this.compName = s;
	}
	
	public String getLogoURL(){
		return this.logoURL;
	}
	
	public void setLogoURL(String s){
		this.logoURL = s;
	}
	
	public String getTicker(){
		return this.ticker;
	}
	
	public void setTicker(String s){
		this.ticker = s;
	}
	
	public String getNation(){
		return this.nation;
	}
	
	public void setNation(String s){
		this.nation = s;
	}
	
	public double getStockPrice(){
		return this.stockPrice;
	}
	
	public void setStockPrice(double s){
		this.stockPrice = s;
	}
	
	public String getDesc(){
		return this.desc;
	}
	
	public void setDesc(String s){
		this.desc = s;
	}
	
	public ArrayList<Hedgefund> getHedgeInvested(){
		return dao.selectCompHedgeList(this.compName);
	}
	
}
