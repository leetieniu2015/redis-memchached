package org.leetieniu.model;

import java.io.Serializable;

public class User implements Serializable {
	
	private static final long serialVersionUID = -1539892560972509861L;
	
	public User() {}
	
	public User(String userId, String username, 
			String password, String message) {
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.message = message;
	}
	
	private String userId;  
    private String username;  
    private String password;
    private String message;
    
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "User : { userId : " + userId + ", username : " + username + ", password : " + password + ", message : "
				+ message + " }";
	}  
}
