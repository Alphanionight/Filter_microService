package org.mql.ws.dao;

import java.util.Hashtable;


public class UserDaoImpl {
	
	private Hashtable<String, String> users;
	private static UserDaoImpl instance = new UserDaoImpl();
	
	private UserDaoImpl() {
		users = new Hashtable<String, String>();
		users.put("houssam", "123");
		users.put("ibtissam", "123");
		users.put("rhita", "123");
		users.put("mohamed", "123");
	}
	
	public static UserDaoImpl getInstance() {
		return instance;
	}
	
	public Hashtable<String, String> getUsers() {
		return users;
	}
	
	public boolean validateAuthentication(String username, String password) {
		if(users.containsKey(username)) {
			if(users.get(username).equals(password)) return true;
			else return false;
		}
		return false;
	}
}
