package com.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.service.AuthenticationService;

@Controller
public class LoginController {
	
	AuthenticationService authenticationService;
	public LoginController(AuthenticationService authenticationService) {
		super();
		this.authenticationService = authenticationService;
	}

	@RequestMapping(path = "/login", method = RequestMethod.GET)
	public String goToLogin() {
		return "login";
	}
	@RequestMapping(path = "/login", method = RequestMethod.POST)
	public String goToLogin(@RequestParam String email,@RequestParam String password,Model model) {
		if(authenticationService.authenticate(email, password)) {
			return "home";
		}
		model.addAttribute("auth-details","invalid Credintials please Check");
		return "login";
	}
}
