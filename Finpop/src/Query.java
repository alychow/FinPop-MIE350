

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Query {

	private Connection connection;

	public Query() {
		connection = DbUtil.getConnection();
	}

	public void insertUser(User user) {
		String insertQuery = "INSERT INTO User (ID,Username,Password,FirstName,LastName) values (?, ?, ?, ?, ?)";
		
		if(this.validUsername(user.getUsername())){
			try {
				PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
				preparedStatement.setInt(1, user.getUserid());
				preparedStatement.setString(2, user.getUsername());
				preparedStatement.setString(3, user.getPassword());
				preparedStatement.setString(4, user.getFirstName());
				preparedStatement.setString(5, user.getLastName());
				preparedStatement.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		else{
			//That username already exists!
		}
		
	}

	public void deleteUser(int userId) {
		
		String deleteQuery = "DELETE * FROM User WHERE ID=?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);
			preparedStatement.setInt(1, userId);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateUsername(int userID, String newUsername) {
		
		String updateQuery = "UPDATE Users SET Username=? WHERE ID=?";
		
		try {
			PreparedStatement ps = connection.prepareStatement(updateQuery);
			ps.setString(1, newUsername);
			ps.setInt(2, userID);
			ps.executeUpdate(updateQuery);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updatePassword(int userID, String newPassword) {

		String updateQuery = "UPDATE Users SET Password=? WHERE ID=?";

		try {
			PreparedStatement ps = connection.prepareStatement(updateQuery);
			ps.setString(1, newPassword);
			ps.setInt(2, userID);
			ps.executeUpdate(updateQuery);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateFirstName(int userID, String newName) {

		String updateQuery = "UPDATE Users SET FirstName=? WHERE ID=?";

		try {
			PreparedStatement ps = connection.prepareStatement(updateQuery);
			ps.setString(1, newName);
			ps.setInt(2, userID);
			ps.executeUpdate(updateQuery);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateLastName(int userID, String newName) {

		String updateQuery = "UPDATE Users SET LastName=? WHERE ID=?";

		try {
			PreparedStatement ps = connection.prepareStatement(updateQuery);
			ps.setString(1, newName);
			ps.setInt(2, userID);
			ps.executeUpdate(updateQuery);

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	//Returns an ArrayList of Strings containing search results
	public ArrayList<String> search(String input) {
		ArrayList<String> searchResults = new ArrayList<String>();
		
		String searchQuery = "SELECT C.Ticker AS Search FROM Company C WHERE C.Ticker "
				+ "LIKE '?' UNION SELECT C.CompanyName AS Search FROM Company C "
				+ "WHERE C.CompanyName LIKE '?' UNION SELECT H.HedgefundName "
				+ "AS Search FROM Hedgefund H WHERE H.HedgefundName LIKE '?'";
		
		try {
			PreparedStatement ps = connection.prepareStatement(searchQuery);
			ps.setString(1, input + "*");
			ps.setString(2, input + "*");
			ps.setString(3, input + "*");
			ResultSet rs = ps.executeQuery(searchQuery);
			while (rs.next()) {
				searchResults.add(rs.getString("Search"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return searchResults;
	}
	
	//Checks if that username already exists when adding a user
	public boolean validUsername(String username){
		boolean validName = true;
		
		String nameQuery = "SELECT U.Username FROM User WHERE U.Username = ?";
		
		try{
			PreparedStatement ps = connection.prepareStatement(nameQuery);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery(nameQuery);
			rs.next();
			if(!rs.wasNull()){
				//Username already exists!
				validName = false;
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
		return validName;
	}
	
	//Check to make sure the login is correct
	public boolean correctLogin(String username, String password){
		boolean correct = true;
		
		String usernameExistsQuery = "SELECT U.Username FROM User U "
				+ "WHERE U.Username = ?";
		
		String matchQuery = "SELECT U.Username, U.Password FROM User U "
				+ "WHERE U.Username = ? AND U.Password = ?";
		
		try{
			PreparedStatement ps = connection.prepareStatement(usernameExistsQuery);
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery(usernameExistsQuery);
			
			rs.next();
			if(rs.wasNull()){
				//Please enter a valid username
				correct = false;
			}
			else{
				ps = connection.prepareStatement(matchQuery);
				ps.setString(1, username);
				ps.setString(2, password);
				rs = ps.executeQuery(matchQuery);
				
				rs.next();
				if(rs.wasNull()){
					//Please the correct password
					correct = false;
				}
				//Otherwise, they entered a valid username and password
			}
		}
		catch(SQLException e){
			e.printStackTrace();
			correct = false;
		}
		return correct;
	}
	
}