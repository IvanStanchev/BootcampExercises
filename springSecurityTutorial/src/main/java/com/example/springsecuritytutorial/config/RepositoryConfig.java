package com.example.springsecuritytutorial.config;

import com.example.springsecuritytutorial.user.UserRepository;
import com.example.springsecuritytutorial.user.MySQLUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "com.example.springsecuritytutorial.user")
public class RepositoryConfig {

    private DataSource dataSource;
    @Bean
    @Primary
    public UserRepository mySQLUserRepository() {
        return new MySQLUserRepository(dataSource);
    }
}
