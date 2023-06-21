package com.example.springsecuritytutorial.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingsController {
    @GetMapping("/hello")
    public String sayHello(){
        return "Hello from our API";
    }

    @GetMapping("/bye")
    public String sayGoodBye(){
        return "Bye from our API";
    }


}
