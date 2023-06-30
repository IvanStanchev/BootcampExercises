package com.example.springsecuritytutorial.controllers;

import com.example.springsecuritytutorial.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
public class GreetingsController {
    private final UserService userService;

    @Autowired
    public GreetingsController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/hello")
    public ResponseEntity<String> sayHello(@RequestHeader(HttpHeaders.AUTHORIZATION) String authorizationHeader) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(userService.sayHello(authorizationHeader));
    }

    @GetMapping("/bye")
    public ResponseEntity<String> sayGoodBye(){
        return ResponseEntity.status(HttpStatus.OK)
                .body("Bye from our API");
    }

    @GetMapping("/admin")
    public ResponseEntity<String> hiAdmin(){
        return ResponseEntity.status(HttpStatus.OK)
                .body("What is it you truly desire");
    }
}

