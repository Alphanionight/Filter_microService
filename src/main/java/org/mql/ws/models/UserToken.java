package org.mql.ws.models;

public class UserToken {
	private String username;
	private String token;
	
	public UserToken() {}

	public UserToken(String user, String token) {
		super();
		this.username = user;
		this.token = token;
	}

	public String getUser() {
		return username;
	}

	public void setUser(String user) {
		this.username = user;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	
}
