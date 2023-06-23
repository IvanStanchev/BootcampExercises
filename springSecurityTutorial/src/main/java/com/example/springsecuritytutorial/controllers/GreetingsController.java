package com.example.springsecuritytutorial.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
public class GreetingsController {
    @GetMapping("/hello")
    public ResponseEntity<String> sayHello(){
        return ResponseEntity.status(HttpStatus.OK)
                .body("Hello from our API");
    }

    @GetMapping("/bye")
    public ResponseEntity<String> sayGoodBye(){
        return ResponseEntity.status(HttpStatus.OK)
                .body("Bye from our API");
    }
    //video ~ 1:55:00
}

