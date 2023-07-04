package com.example.springsecuritytutorial.auth;

import com.example.springsecuritytutorial.config.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collection;

import static jdk.internal.org.jline.reader.impl.LineReaderImpl.CompletionType.List;

@Service
public class AuthenticationService {

//    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationProvider authenticationProvider;
    private final RestTemplate restTemplate;

    @Autowired
    public AuthenticationService(PasswordEncoder passwordEncoder,
                                 JwtService jwtService,
                                 AuthenticationProvider authenticationProvider) {
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationProvider = authenticationProvider;
        this.restTemplate = new RestTemplate();
    }
    private String baseUrl = "http://localhost:8080/users/";

    public TokenResponse register(RegisterRequest request) {
        ResponseEntity<RegisterResponse> responseEntity = restTemplate.postForEntity(baseUrl, request, RegisterResponse.class);
        RegisterResponse response = responseEntity.getBody();

        int id = response.getId();
        String email = response.getEmail();
        return generateJwt(id, email);
    }

    public AuthenticationDTO authenticate(AuthenticationDTO request) {
        String url = baseUrl + request.getEmail();
        ResponseEntity<AuthenticationDTO> responseEntity = restTemplate.getForEntity(url, AuthenticationDTO.class);
        AuthenticationDTO response = responseEntity.getBody();

        if(!response.getPassword().equals(request.getPassword())) {
            throw new RuntimeException("Invalid password");
        }
        List<? extends GrantedAuthority> grantedAuthorities = new ArrayList<>(stringlist);
        Collection<? extends GrantedAuthority> collection = grantedAuthorities;


        new UsernamePasswordAuthenticationToken(
                response.getEmail(),
                response.getPassword(),
                grantedAuthorities
        );

        return generateJwt(user);
    }

    public TokenResponse generateJwt(int id, String email){
        String jwtToken = jwtService.generateToken(id, email);
        return TokenResponse.builder()
                .token(jwtToken)
                .build();
    }
}
