package aseStruts;
import java.sql.*;

public class Login {
    private String name;
    private String password;
    
    public String execute() throws Exception {
        String jdbcURL = "jdbc:mysql://localhost:3306/UserDatabase";
        String dbUser = "root";
        String dbPassword = "";
 
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
        String sql = "SELECT * FROM users WHERE username = ? and password = ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, name);
        statement.setString(2, password);
 
        ResultSet result = statement.executeQuery();
 
        User user = null;
 
        if (result.next()) {
        	user = new User(result.getString("username"), result.getString("password"));
        	if (user.verify(name, password)) {
        		return "success";
        	}
        	else {
        		return "error";
        	}

        }
 
        connection.close();

        return "error";
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
    
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
}
