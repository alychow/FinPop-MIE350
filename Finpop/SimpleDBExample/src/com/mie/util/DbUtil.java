package com.mie.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbUtil {
	
	// Initializes connection object as null
	private static Connection connection = null;
	
	// Connects the connection object to the database so queries can be run against connected database 
	public static Connection getConnection() {
		// Check if connection is null 
		if (connection != null)
			return connection;
		// If not, proceed to get connection 
		else {
			try {
				Properties prop = new Properties();
				InputStream inputStream = DbUtil.class.getClassLoader()
						.getResourceAsStream("/db.properties");
				prop.load(inputStream);
				String driver = prop.getProperty("driver");
				String url = prop.getProperty("url");
				String user = prop.getProperty("user");
				String password = prop.getProperty("password");
				Class.forName(driver);
				connection = DriverManager.getConnection(url, user, password);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return connection;
		}

	}
}
