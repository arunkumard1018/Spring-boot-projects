package com.springsecurity.app.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping(path = "/")
    public String welcome() {
        String WelcomeText = "Welcome to Blogging Application Restful services";
        return "<h1 style='margin-top: 50px; text-align: center; color: green;'>" + WelcomeText + "</h1>";
    }


}

