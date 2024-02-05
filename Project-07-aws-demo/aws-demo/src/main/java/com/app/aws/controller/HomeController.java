package com.app.aws.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public Hello hello(){
        return new Hello("Hello User");
    }
}

record Hello(String message){}
