//package com.example.springsecuritytutorial.config;
//
//import com.example.springsecuritytutorial.user.UserDAO;
//import com.example.springsecuritytutorial.user.UserRepository;
//import com.example.springsecuritytutorial.user.UserRepositoryMySQL;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Profile;
//
//@Configuration
//@ComponentScan(basePackages = "com.example.springsecuritytutorial.user")
//public class RepositoryConfig {
//
//    private final UserDAO userDAO;
//
//    @Profile("mysql")
//    @Bean
//    public UserRepository userRepositoryMySQL(UserDAO userDAO) {
//        return new UserRepositoryMySQL(userDAO);
//    }
//}
