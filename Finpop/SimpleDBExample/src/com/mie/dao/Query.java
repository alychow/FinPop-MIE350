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
	
	public String insertUser(User user) {
		
		String inserted = new String();
		
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
		
		return inserted;
		
	}
	
	public void insertPortfolio(Portfolio port){
		String insertQuery = "INSERT INTO Portfolio "
				+ "(Username, CompanyName, Ticker, NumberShares) values (?, ?, ?, ?)";
		
		try{
			PreparedStatement ps = connection.prepareStatement(insertQuery);
			ps.setString(1, port.getUsername());
			ps.setString(2, port.getCompName());
			ps.setString(3, port.getTicker());
			ps.setInt(4, port.getNumShares());
			ps.executeUpdate(insertQuery);	
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	/* -------------------------------DELETE QUERIES----------------------------*/
	
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
	
	public void deletePortfolio(String username){
		username = "'" + username + "'";
		String deleteQuery = "DELETE * FROM Portfolio WHERE Username = " + username;
		try{
			Statement stat = connection.createStatement();
			stat.executeQuery(deleteQuery);
			
		}
		catch(SQLException e){
			e.printStackTrace();
		}
	}

	
	
	/*----------------------------UPDATE QUERIES----------------------------------*/
	
	
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
		String searchQuery = "SELECT CompanyName,Ticker,Nationality,StockPrice,Description FROM Company WHERE CompanyName = " + search;
		
		try{
			Statement stat = connection.createStatement();
			ResultSet rs = stat.executeQuery(searchQuery);
			rs.next();
			comp.setCompName(rs.getString(1));
			comp.setTicker(rs.getString(2));
			comp.setNation(rs.getString(3));
			comp.setStockPrice( Double.parseDouble(rs.getString(4)));
			comp.setDesc(rs.getString(5));
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
		return comp;
		
	}
	
	//Gets the list of hedgefunds that are invested in that company
	public ArrayList<String> selectCompHedgeList(String comp){
		
		comp = "'" + comp + "'";
		ArrayList<String> hedgeList = new ArrayList<String>();
		String searchQuery = "SELECT HedgefundName FROM InvestsIn WHERE CompanyName = " + comp;
		
		try{
			Statement stat = connection.createStatement();
			ResultSet rs = stat.executeQuery(searchQuery);
			while(rs.next()){
				hedgeList.add(rs.getString("HedgefundName"));
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
		InvestsIn inv = new InvestsIn();
		hedgeName = "'" + hedgeName + "'";
		String searchQuery = "SELECT I.CompanyName, I.Ticker, I.SharesOwned "
				+ "FROM InvestsIn I WHERE I.HedgefundName = " + hedgeName;
		
		try{
			Statement stat = connection.createStatement();
			ResultSet rs = stat.executeQuery(searchQuery);
			while(rs.next()){
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
	
	
	public ArrayList<UserPortfolio> selectUserPortfolio(String username){
		
		username = "'" + username + "'";
		
		String searchQuery = "SELECT P.CompanyName AS CompanyName, "
				+ "P.NumberShares AS NumberShares, C.StockPrice AS StockPrice, "
				+ "C.StockPrice*P.NumberShares AS TotalMoney FROM "
				+ "Portfolio P INNER JOIN Company C ON P.Ticker = C.Ticker "
				+ "WHERE P.Username = " + username;
		
		ArrayList<UserPortfolio> investments = new ArrayList<UserPortfolio>();
		UserPortfolio investment = new UserPortfolio();
		
		try{
			Statement stat = connection.createStatement();
			ResultSet rs = stat.executeQuery(searchQuery);
			while(rs.next()){
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
		String searchQuery = "SELECT * FROM Company WHERE CompanyName = " + compName;
		
		try{
			Statement stat = connection.createStatement();
			ResultSet rs = stat.executeQuery(searchQuery);
			rs.next();
			if(rs.wasNull()) exists = false;
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
		String searchQuery = "SELECT * FROM Company WHERE Ticker = " + ticker;
		
		try{
			Statement stat = connection.createStatement();
			ResultSet rs = stat.executeQuery(searchQuery);
			rs.next();
			if(rs.wasNull()) exists = false;
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
		String searchQuery = "SELECT * FROM Hedgefund WHERE HedgefundName = " + hedgeName;
		
		try{
			Statement stat = connection.createStatement();
			ResultSet rs = stat.executeQuery(searchQuery);
			rs.next();
			if(rs.wasNull()) exists = false;
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
			rs.next();
			if(!rs.wasNull()){
				//Username already exists!
				nameExists = true;
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
		return nameExists;
	}
	
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
			
			rs.next();
			if(rs.wasNull()){
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