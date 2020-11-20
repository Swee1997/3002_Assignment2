package aseStruts;

import java.sql.*;
public class Login {
    private String name;
    private String password;
    
    // Check verification result
    public String execute() throws Exception {
        User user = new User(name, password);
        if(user.getInDatabase())
        {
        	return "success";
        }
        else
        {
        	return "error";
        }
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
