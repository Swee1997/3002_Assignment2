package aseStruts;

public class User {

	private String username;
	private String password;
	
	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public boolean verify(String username, String password) {
		if (username.equals(this.username) && password.equals(this.password)) {
			return true;
		}
		else {
			return false;
		}
	}
	
}
