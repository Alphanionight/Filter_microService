package org.mql.ws.business;

import java.util.Hashtable;

public class Session {
	private static Hashtable<String, String> users = new Hashtable<String, String>();
	
	public Session() {}

	public static Hashtable<String, String> getUsers() {
		return users;
	}

	public static void setUsers(Hashtable<String, String> users) {
		Session.users = users;
	}
	
	public static void addUser(String username, String token) {
		users.put(username, token);
	}
	
	public static void removeUser(String username) {
		users.remove(username);
	}
	
	public static String getToken(String username) {
		return users.get(username);
	}
	
	public static boolean validSession(String username, String token) {
		if(users.containsKey(username) && token.equals(users.get(username))) return true;
		return false;
	}
	
	public static boolean validToken(String token) {
		if(users.contains(token)) return true;
		return false;
	}
}
