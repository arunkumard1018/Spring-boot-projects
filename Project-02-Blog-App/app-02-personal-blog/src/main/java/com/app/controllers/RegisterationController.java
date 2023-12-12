package com.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.app.model.User;
import com.app.service.RegisterationService;

import jakarta.validation.Valid;

@Controller
public class RegisterationController {
	
	
	RegisterationService registerationService;
	public RegisterationController(RegisterationService registerationService) {
		super();
		this.registerationService = registerationService;
	}

	@RequestMapping(path = "/register", method = RequestMethod.GET)
	public String goToRegister(User user) {
		return "register";
	}
	
	@RequestMapping(path = "/register", method = RequestMethod.POST)
	public String goToRegister(@Valid User user,BindingResult result,ModelMap model) {
		
		if(result.hasErrors()) {
			return "/register";
		}
		registerationService.register(user);
		return "redirect:/";
	}
}
