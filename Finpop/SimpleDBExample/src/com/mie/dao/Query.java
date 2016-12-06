package com.mie.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.mie.util.*;
import com.mie.model.*;

public class Query {

	public Connection connection;
	
	public Query(){
		connection = DbUtil.getConnection();
	}

	/* ---------------------------------INSERT QUERIES-----------------------------------*/
	
	/* This function inserts a user into the database. It requires that a user is passed to the function with all of its
	member fields already entered. */
	
	public String insertUser(User user) {
		
		String inserted = new String();
		
		
		/* This is the query string that is ran in access. Note that it is a PreparedStatement becuase of the ?'s */
		
		String insertQuery = "INSERT INTO User "
				+ "(Username,Password,FirstName,LastName) values (?, ?, ?, ?)";
		
		if(usernameExists(user.getUsername())){
			inserted = "That username already exists!";
		}
		else{
			if(!validPassword(user.getPassword())){
				inserted = "Password needs to be at least 8 characters!";
			}
			else{
				try {
					/* These objects set the ?'s to the values which are then executed as 
					a query against the database*/
					
					PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
					preparedStatement.setString(1, user.getUsername());
					preparedStatement.setString(2, user.getPassword());
					preparedStatement.setString(3, user.getFirstName());
					preparedStatement.setString(4, user.getLastName());
					preparedStatement.executeUpdate();
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
				inserted = "User " + user.getFirstName() + " " + user.getLastName() + " was inserted.";
			}
			
		}
		
		/* Returns a string saying whether or not the user was inserted, or the specific problem that occured
		as to why they were not inserted */
		return inserted;
		
	}
	
	/* This function inserts a portfolio into the portfolio table in the database */
	public boolean insertPortfolio(Portfolio port){
		boolean inserted = true;
		String insertQuery = "INSERT INTO Portfolio "
				+ "(Username, CompanyName, Ticker, NumberShares) values (?, ?, ?, ?)";
		
		try{
			PreparedStatement ps = connection.prepareStatement(insertQuery);
			ps.setString(1, port.getUsername());
			ps.setString(2, port.getCompName());
			ps.setString(3, port.getTicker());
			ps.setInt(4, port.getNumShares());
			ps.executeUpdate();	
		}
		catch(SQLException e){
			inserted = false;
			e.printStackTrace();
		}
		return inserted;
	}
	
	/* -------------------------------DELETE QUERIES----------------------------*/
	
	/* This function deletes the user from the database with the specified username that is passed into the function */
	public void deleteUser(String username) {
		
		String deleteQuery = "DELETE * FROM User WHERE Username='?'";
		try {
			PreparedStatement ps = connection.prepareStatement(deleteQuery);
			ps.setString(1, username);
			ps.executeUpdate();
			
			//If the user is deleted, their portfolio should be deleted too
			deletePortfolio(username);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/* This function deletes the company from the users portfolio with the specified company name that is passed into the function, using the username to find the specific portfolio */
	public void deleteCompFromPortfolio(String compName,String username){
		username = "'" + username + "'";
		compName = "'" + compName + "'";
		String deleteQuery = "DELETE * FROM Portfolio WHERE Username = " + username + " AND CompanyName = " + compName;
		try{
			Statement stat = connection.createStatement();
			stat.execute(deleteQuery);
			
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	/*----------------------------UPDATE QUERIES----------------------------------*/
	
	/* This function updates the username of the user */
	public void updateUsername(int oldUsername, String newUsername) {
		
		String updateQuery = "UPDATE Users SET Username='?' WHERE Username='?'";
		
		try {
			PreparedStatement ps = connection.prepareStatement(updateQuery);
			ps.setString(1, newUsername);
			ps.setInt(2, oldUsername);
			ps.executeUpdate(updateQuery);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/* This function updates the password of the user */
	public void updatePassword(int username, String newPassword) {

		String updateQuery = "UPDATE Users SET Password='?' WHERE Username='?'";

		try {
			PreparedStatement ps = connection.prepareStatement(updateQuery);
			ps.setString(1, newPassword);
			ps.setInt(2, username);
			ps.executeUpdate(updateQuery);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/* This function updates the first name of the user */
	public void updateFirstName(int username, String newName) {

		String updateQuery = "UPDATE Users SET FirstName='?' WHERE Username='?'";

		try {
			PreparedStatement ps = connection.prepareStatement(updateQuery);
			ps.setString(1, newName);
			ps.setInt(2, username);
			ps.executeUpdate(updateQuery);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/* This function updates the last name of the user */
	public void updateLastName(int username, String newName) {

		String updateQuery = "UPDATE Users SET LastName='?' WHERE Username=?";

		try {
			PreparedStatement ps = connection.prepareStatement(updateQuery);
			ps.setString(1, newName);
			ps.setInt(2, username);
			ps.executeUpdate(updateQuery);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/* this function updates the number of shares(value) that a user(username) invests in a certain company(compName)*/
	public void updateCompFromPortfolio(String compName, int value, String username){
		
		username = "'"+username+"'";
		compName = "'"+compName+"'";
		
		String updateQuery = "UPDATE Portfolio SET NumberShares=" + value + " WHERE Username= " + username + 
				" AND CompanyName=" + compName;

		try {
			Statement stat = connection.createStatement();
			stat.executeUpdate(updateQuery);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	/*----------------------------------SELECT QUERIES----------------------------*/
	
	//Returns an ArrayList of Strings containing the suggested results
	public ArrayList<String> selectSuggestedResults(String input) {
		
		input = "'" + input + "*'";
		
		ArrayList<String> suggestedResults = new ArrayList<String>();
		
		String searchQuery = "SELECT C.Ticker AS Search FROM Company C WHERE C.Ticker "
				+ "LIKE " + input + " UNION SELECT C.CompanyName AS Search FROM Company C "
				+ "WHERE C.CompanyName LIKE " + input + " UNION SELECT H.HedgefundName "
				+ "AS Search FROM Hedgefund H WHERE H.HedgefundName LIKE " + input;
		
		try {
			
			Statement stat = connection.createStatement();
			ResultSet rs = stat.executeQuery(searchQuery);
			while (rs.next()) {
				suggestedResults.add(rs.getString("Search"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return suggestedResults;
	}
	
	//Returns the company object that was searched
	public Company selectCompany (String search){
		Company comp = new Company();
		search = "'" + search + "'";
		String searchQuery = "SELECT CompanyName,Ticker,Nationality,StockPrice,Description,LogoURL FROM Company WHERE CompanyName = " + search+" "
				+ "OR Ticker = "+search;
		
		try{
			Statement stat = connection.createStatement();
			ResultSet rs = stat.executeQuery(searchQuery);
			rs.next();
			comp.setCompName(rs.getString(1));
			comp.setTicker(rs.getString(2));
			comp.setNation(rs.getString(3));
			comp.setStockPrice( Double.parseDouble(rs.getString(4)));
			comp.setDesc(rs.getString(5));
			comp.setLogoURL(rs.getString(6));

		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
		return comp;
		
	}
	
	//Returns the hedgefund object that was searched
	public Hedgefund selectHedgefund (String search){
			Hedgefund hedge = new Hedgefund();
			search = "'" + search + "'";
			String searchQuery = "SELECT HedgefundName,Country,Headquarters,Description FROM Hedgefund WHERE HedgefundName = " + search;
			
			try{
				Statement stat = connection.createStatement();
				ResultSet rs = stat.executeQuery(searchQuery);
				rs.next();
				hedge.setHedgeName(rs.getString(1));
				hedge.setCountry(rs.getString(2));
				hedge.setHQ(rs.getString(3));
				hedge.setDesc(rs.getString(4));
			}
			catch(SQLException e){
				e.printStackTrace();
			}
			
			return hedge;
			
		}
	
	//Gets the list of hedgefunds that are invested in that company
	public ArrayList<Hedgefund> selectCompHedgeList(String compOrTicker){
		compOrTicker = "'"+compOrTicker+"'";
		String hedgeFundName = "";
		ArrayList<Hedgefund> hedgeList = new ArrayList<Hedgefund>();
		String searchQuery = "SELECT I.HedgefundName FROM InvestsIn I INNER JOIN Company C ON I.CompanyName = C.CompanyName"
				+ " WHERE I.CompanyName = " + compOrTicker + " OR C.Ticker = " + compOrTicker;
		
		try{
			Statement stat = connection.createStatement();
			ResultSet rs = stat.executeQuery(searchQuery);
			while(rs.next()){
				hedgeFundName = rs.getString("HedgefundName");
				Hedgefund hedgefund = new Hedgefund();
				hedgefund.setHedgeName(hedgeFundName);
				hedgeList.add(hedgefund);
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
		return hedgeList;
		
	}
	
	//Gets the list of companies that that hedgefund is invested in
	public ArrayList<InvestsIn> selectHedgeInvestIn(String hedgeName){
		ArrayList<InvestsIn> compList = new ArrayList<InvestsIn>();
		hedgeName = "'" + hedgeName + "'";
		String searchQuery = "SELECT I.CompanyName, I.Ticker, I.SharesOwned "
				+ "FROM InvestsIn I WHERE I.HedgefundName = " + hedgeName;
		
		try{
			Statement stat = connection.createStatement();
			ResultSet rs = stat.executeQuery(searchQuery);
			while(rs.next()){
				InvestsIn inv = new InvestsIn();
				inv.setCompanyName(rs.getString("CompanyName"));
				inv.setTicker(rs.getString("Ticker"));
				inv.setSharesOwned(rs.getInt("SharesOwned"));
				compList.add(inv);
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
		return compList;
	}
	
	//gets the users portfolio with investment information such as company, number of shares in company
	public ArrayList<UserPortfolio> selectUserPortfolio(String username){
		
		username = "'" + username + "'";
		
		String searchQuery = "SELECT P.CompanyName AS CompanyName, "
				+ "P.NumberShares AS NumberShares, C.StockPrice AS StockPrice, "
				+ "C.StockPrice*P.NumberShares AS TotalMoney FROM "
				+ "Portfolio P INNER JOIN Company C ON P.Ticker = C.Ticker "
				+ "WHERE P.Username = " + username;
		
		ArrayList<UserPortfolio> investments = new ArrayList<UserPortfolio>();
		
		try{
			Statement stat = connection.createStatement();
			ResultSet rs = stat.executeQuery(searchQuery);
			while(rs.next()){
				UserPortfolio investment = new UserPortfolio();
				investment.setCompName(rs.getString("CompanyName"));
				investment.setNumShares(rs.getInt("NumberShares"));
				investment.setStockPrice(rs.getDouble("StockPrice"));
				investment.setTotalMoney(rs.getDouble("TotalMoney"));
				investments.add(investment);
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
		return investments;
		
	}
	
	
	/*---------------------------------BOOLEAN CHECKS--------------------------------*/
	
	//Returns if is a company
	public boolean isCompany(String compName){
		boolean exists = true;
		compName = "'" + compName + "'";
		String searchQuery = "SELECT CompanyName FROM Company WHERE CompanyName = " + compName;
		
		try{
			Statement stat = connection.createStatement();
			ResultSet rs = stat.executeQuery(searchQuery);
			if(!rs.isBeforeFirst()) exists = false;
			}
		catch(SQLException e){
			e.printStackTrace();
		}
		
		return exists;
	}
	
	//Returns if is a ticker
	public boolean isTicker(String ticker){
		boolean exists = true;
		ticker = "'" + ticker + "'";
		String searchQuery = "SELECT CompanyName FROM Company WHERE Ticker = " + ticker;
		
		try{
			Statement stat = connection.createStatement();
			ResultSet rs = stat.executeQuery(searchQuery);
			
			if(!rs.isBeforeFirst()) exists = false;
			}
		catch(SQLException e){
			e.printStackTrace();
		}
		
		return exists;
	}
	
	//Returns if is hedgefund
	public boolean isHedgefund(String hedgeName){
		boolean exists = true;
		hedgeName = "'" + hedgeName + "'";
		String searchQuery = "SELECT HedgefundName FROM Hedgefund WHERE HedgefundName = " + hedgeName;
		
		try{
			Statement stat = connection.createStatement();
			ResultSet rs = stat.executeQuery(searchQuery);
			if(!rs.isBeforeFirst()) exists = false;
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
		return exists;
	}
	
	//Checks if that username already exists when adding a user
	public boolean usernameExists(String username){
		boolean nameExists = false;
		username = "'" + username + "'";
		String nameQuery = "SELECT U.Username FROM User U WHERE U.Username = " + username;
		
		try{
			Statement stat = connection.createStatement();
			ResultSet rs = stat.executeQuery(nameQuery);
			if(rs.isBeforeFirst()){
				//Username already exists!
				nameExists = true;
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
		return nameExists;
	}
	
	//Check if password is greater than 8 characters 
	public boolean validPassword(String pass){
		boolean validPass = false;
		if(pass.length() >= 8){
			validPass = true;
		}
		return validPass;
	}
	
	//Check to make sure the login is correct
	public boolean isALogin(String username, String password){
		boolean correct = true;
		username = "'" + username + "'";
		password = "'" + password + "'";
		
		String usernameExistsQuery = "SELECT U.Username FROM User U "
				+ "WHERE U.Username = " + username;
		
		String matchQuery = "SELECT U.Username, U.Password FROM User U "
				+ "WHERE U.Username = " + username + " AND U.Password = " + password;
		
		try{
			Statement stat = connection.createStatement();
			ResultSet rs = stat.executeQuery(usernameExistsQuery);
			
			if(!rs.isBeforeFirst()){
				//Please enter a valid username
				correct = false;
			}
			else{
				rs = stat.executeQuery(matchQuery);
				
				rs.next();
				if(rs.wasNull()){
					//Please enter correct password
					correct = false;
				}
				//Otherwise, they entered a valid username and password
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return correct;
	}
	
}
