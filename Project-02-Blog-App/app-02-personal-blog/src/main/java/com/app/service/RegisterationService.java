package com.app.service;

import org.springframework.stereotype.Service;

import com.app.entity.UserEntity;
import com.app.jpa.UserRepositry;
import com.app.model.User;


@Service
public class RegisterationService {
	
	
	UserRepositry userRepositry;
	public RegisterationService(UserRepositry userRepositry) {
		super();
		this.userRepositry = userRepositry;
	}

	public boolean register(User user) {
		UserEntity newUser = new UserEntity(user.getName(), user.getEmail(),user.getPassword());
		UserEntity save = userRepositry.save(newUser);
		System.out.println(save);
		return true;
	}

}
