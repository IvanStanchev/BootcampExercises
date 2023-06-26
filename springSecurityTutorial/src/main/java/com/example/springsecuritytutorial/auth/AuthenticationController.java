package com.example.springsecuritytutorial.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request) {
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("Authorization", "Bearer " + jwtToken);
        return ResponseEntity.ok(authenticationService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody AuthenticationRequest request) {
        return ResponseEntity.ok(authenticationService.authenticate(request));
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
