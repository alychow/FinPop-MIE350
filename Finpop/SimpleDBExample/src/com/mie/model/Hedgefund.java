package com.mie.model;
import java.util.ArrayList;
import com.mie.dao.*;


		/* ---------------------------------HEDGEFUND-----------------------------------*/
	
	/* This class stores Hedgefund information of the name, headquarter country, headquarter city, description and logo URL to be 
	displayed onto each Hedgefund's profile when selected from the user's portfolio or in search results. This class also
	returns what companies this selected hedgefund is investing in, updated quarterly. */

public class Hedgefund {

	//Every attribute gets an element
	private String hedgeName;
	private String country;
	private String HQ;
	private String desc;
	
	// Initializes new query from Query class
	private Query dao = new Query();
	
	// Initializes the Hedgefund class 
	public Hedgefund(){
		this.hedgeName = "";
		this.country = "";
		this.HQ = "";
		this.desc = "";
	}
	
	// Sets hedgefund class with input variables required for the hedgefund to be displayed on FinPOP
	public Hedgefund(String name, String country, String HQ, String desc){
		this.country = country;
		this.hedgeName = name;
		this.HQ = HQ;
		this.desc = desc;
	}
	
	// Returns the hedgefund name 
	public String getHedgeName(){
		return this.hedgeName;
	}
	
	// Sets the hedgefund name
	public void setHedgeName(String s){
		this.hedgeName = s;
	}
	
	// Returns the headquarter country the hedgefund is located in 
	public String getCountry(){
		return this.country;
	}
	
	// Sets the headquarter country the hedgefund is located in 
	public void setCountry(String s){
		this.country = s;
	}
	
	// Returns the headquarter city 
	public String getHQ(){
		return this.HQ;
	}
	
	// Sets the headquarter city
	public void setHQ(String s){
		this.HQ = s;
	}
	
	// Returns hedgefund description 
	public String getDesc(){
		return this.desc;
	}
	
	// Sets hedgefund description
	public void setDesc(String s){
		this.desc = s;
	}
	
	// Returns companies the selected hedgefund is investing in, updated quarterly
	public ArrayList<InvestsIn> compInvestedIn(){
		return dao.selectHedgeInvestIn(this.hedgeName);
	}
	
}
