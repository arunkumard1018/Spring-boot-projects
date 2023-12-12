package com.app.service;

import org.springframework.stereotype.Service;

import com.app.entity.UserEntity;
import com.app.jpa.UserRepositry;

@Service
public class AuthenticationService {
	
	UserRepositry userRepositry;
	public AuthenticationService(UserRepositry userRepositry) {
		this.userRepositry = userRepositry;
	}
	
	public boolean authenticate(String email,String Password) {
		try{		
			UserEntity userEntity = userRepositry.getReferenceById(email);
			if(email.equals(userEntity.getEmail()) && Password.equals(userEntity.getPassword())) {
				return true;
			}
		}catch (Exception e) {
			return false;
		}
		return false;
	}
	
	
}
