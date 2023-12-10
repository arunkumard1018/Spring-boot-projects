package com.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.service.LoginService;

@Controller
public class LoginController {
	
	LoginService loginService;
	
	public LoginController(LoginService loginService) {
		super();
		this.loginService = loginService;
	}
	

	@RequestMapping(path = "/login", method = RequestMethod.GET)
	public String goToLogin() {
		return "login";
	}

	@RequestMapping(path = "/login", method = RequestMethod.POST)
	public String goToLogin(@RequestParam String userName, String password) {
		
		if(loginService.authenticate(userName, password)) {
			return "/";
		}
		
		return "login";
	}
}
