package com.mie.model;
import java.util.ArrayList;
import com.mie.dao.*;

public class Hedgefund {

	//Every attribute gets an element
	private String hedgeName;
	private String country;
	private String HQ;
	private String desc;
	
	public Hedgefund(){
		this.hedgeName = "";
		this.country = "";
		this.HQ = "";
		this.desc = "";
	}
	
	public Hedgefund(String name, String country, String HQ, String desc){
		this.country = country;
		this.hedgeName = name;
		this.HQ = HQ;
		this.desc = desc;
	}
	
	public String getHedgeName(){
		return this.hedgeName;
	}
	
	public void setHedgeName(String s){
		this.hedgeName = s;
	}
	
	public String getCountry(){
		return this.country;
	}
	
	public void setCountry(String s){
		this.country = s;
	}
	
	public String getHQ(){
		return this.HQ;
	}
	
	public void setHQ(String s){
		this.HQ = s;
	}
	
	public String getDesc(){
		return this.desc;
	}
	
	public void setDesc(String s){
		this.desc = s;
	}
	
	public ArrayList<InvestsIn> compInvestedIn(){
		Query dao = new Query();
		return dao.selectHedgeInvestIn(this.hedgeName);
	}
	
}
