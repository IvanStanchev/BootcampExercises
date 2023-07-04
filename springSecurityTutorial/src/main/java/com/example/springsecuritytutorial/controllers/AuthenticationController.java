package com.example.springsecuritytutorial.controllers;

import com.example.springsecuritytutorial.auth.AuthenticationDTO;
import com.example.springsecuritytutorial.auth.TokenResponse;
import com.example.springsecuritytutorial.auth.AuthenticationService;
import com.example.springsecuritytutorial.auth.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<TokenResponse> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(authenticationService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<TokenResponse> login(@RequestBody AuthenticationDTO request) {
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }
    @PostMapping("/login1")
    public ResponseEntity<String> login1(@RequestBody AuthenticationDTO request) {
        return ResponseEntity.ok(request.getEmail() + " " + request.getPassword());
    }

    @GetMapping("/register")
    public ResponseEntity<String> showRegistrationPage() {
        return ResponseEntity.ok("Registration page");
    }

    @GetMapping("/login")
    public ResponseEntity<String> showLoginPage() {
        return ResponseEntity.ok("Login page");
    }
}
