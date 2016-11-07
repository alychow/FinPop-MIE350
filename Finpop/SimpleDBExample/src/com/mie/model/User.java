package com.mie.model;


import java.util.ArrayList;
import java.util.Date;
import com.mie.dao.*;

public class User {
	
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private Query dao = new Query();

	public User(String firstName, String lastName, String username, String password){
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setPassword(password);
		this.setUsername(username);
	}
	
	public User(){
		this.firstName = "";
		this.lastName = "";
		this.username = "";
		this.password = "";
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String s) {
		this.username = s;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String s) {
		this.password = s;
	}
	
	public ArrayList<UserPortfolio> getInvestments(){
		return dao.selectUserPortfolio(this.username);
	}
	
	
	
}