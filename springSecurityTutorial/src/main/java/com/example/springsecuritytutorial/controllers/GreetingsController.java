package com.example.springsecuritytutorial.controllers;

import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
public class GreetingsController {
    @GetMapping("/hello")
    public ResponseEntity<String> sayHello(@RequestHeader(HttpHeaders.AUTHORIZATION) String authorizationHeader) {
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            String jwtToken = authorizationHeader.substring(7);

            return ResponseEntity.status(HttpStatus.OK)
                    .body("Hello from our API");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("Invalid or missing authorization header");
        }
    }


    @GetMapping("/bye")
    public ResponseEntity<String> sayGoodBye(){
        return ResponseEntity.status(HttpStatus.OK)
                .body("Bye from our API");
    }
    //video ~ 1:55:00
}

