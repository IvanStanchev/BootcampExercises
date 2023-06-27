//package com.example.springsecuritytutorial.auth;
//
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.BadCredentialsException;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//
//import java.util.List;
//
//public class CustomAuthenticationProvider implements AuthenticationProvider {
//
//    @Override
//    public Authentication authenticate(AuthenticationRequest request) throws AuthenticationException {
//        String username = request.getEmail();
//        String password = request.getPassword();
//
//
//        if ("admin".equals(username) && "password".equals(password)) {
//            return new UsernamePasswordAuthenticationToken(username, password, List.of(new SimpleGrantedAuthority("USER")));
//        } else {
//            throw new BadCredentialsException("Invalid username or password");
//        }
//    }
//
//    @Override
//    public boolean supports(Class<?> authenticationType) {
//         return authenticationType.equals(UsernamePasswordAuthenticationToken.class);
//    }
//}
//
