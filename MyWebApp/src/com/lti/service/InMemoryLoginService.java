package com.lti.service;

import java.util.HashMap;

import sun.rmi.runtime.Log;

public class InMemoryLoginService {

	private HashMap<String, String> users = new HashMap<>();

	public  InMemoryLoginService() {
		users.put("Kora", "123"); // in memory data
		users.put("Rashmi", "1234");
		users.put("Komal", "12345");
	}

	public boolean isValidUser(String username, String password) {
		if (users.containsKey(username))
			if (users.get(username).equals(password))

				return true;
		return false;

	}
}
