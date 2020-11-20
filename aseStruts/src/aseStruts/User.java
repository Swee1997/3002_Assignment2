package aseStruts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;

public class User {

	private String username;
	private String password;
	private boolean inDatabase=false;
	
	// constructor function which connects to database and verifies user
	public User(String username, String password) throws Exception {
		this.username = username;
		this.password = password;
		
        String jdbcURL = "jdbc:mysql://localhost:3306/UserDatabase";
        String dbUser = "root";
        String dbPassword = "";
 
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
        String sql = "SELECT * FROM users WHERE username = ? and password = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, username);
        statement.setString(2, password);
 
        ResultSet result = statement.executeQuery();
 
        if (result.next()) {
        	inDatabase = true;
        }
 
        connection.close();
	}
	
	//get inDatabase
	public boolean getInDatabase()
	{
		return inDatabase;
	}
	
}
