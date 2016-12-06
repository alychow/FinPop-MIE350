package com.mie.model;


import java.util.ArrayList;
import java.util.Date;
import com.mie.dao.*;

		/* ---------------------------------USER-----------------------------------*/
	
	/* This class stores User information of the first name, last name, username, password, to allow access for 
	registered users on FinPOP. This class also returns the companies the user currently invests in. */

public class User {
	
	// Every attribute gets an element
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	
	// Initializes new query from Query class
	private Query dao = new Query();

	// Initializes the User class
	public User(){
		this.firstName = "";
		this.lastName = "";
		this.username = "";
		this.password = "";
	}
	
	// Sets user class with input variables required for the user to register and login
	public User(String firstName, String lastName, String username, String password){
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setPassword(password);
		this.setUsername(username);
	}

	// Returns the first name of user
	public String getFirstName() {
		return firstName;
	}
	
	// Sets the first name of user during registration
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	// Returns the last name of user
	public String getLastName() {
		return lastName;
	}

	// Sets the last name of user during registration
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	// Returns the username 
	public String getUsername() {
		return this.username;
	}

	// Sets the username of user during registration
	public void setUsername(String s) {
		this.username = s;
	}

	// Returns the password
	public String getPassword() {
		return this.password;
	}

	// Sets the password of user during registration or when user creates a new password in account
	public void setPassword(String s) {
		this.password = s;
	}
	
	// Returns the companies (with name, number of shares, stock price and total money) the user invested in 
	public ArrayList<UserPortfolio> getInvestments(){
		return dao.selectUserPortfolio(this.username);
	}
}
