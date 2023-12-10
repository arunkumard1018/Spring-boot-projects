package com.app.service;

import org.springframework.stereotype.Service;

@Service
public class LoginService {
	
	public boolean authenticate(String username, String password) {
		return (username == "admin" && password == "root");
	}

}
