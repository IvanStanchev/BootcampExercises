package com.example.springsecuritytutorial.user;

import com.example.springsecuritytutorial.config.JwtService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;
    private final JwtService jwtService;

    public UserService(UserRepository userRepository, JwtService jwtService) {
        this.userRepository = userRepository;
        this.jwtService = jwtService;
    }

    public Optional<User> getById(int id) {
        return userRepository.findById(id);
    }
    public Optional<User> getByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    public AddUserResponse addUser(AddUserRequest request) {
        String email = request.getEmail();

        User user = new User();
        user.setFirstname(request.getFirstname());
        user.setLastname(request.getLastname());
        user.setEmail(email);
        user.setPassword(request.getPassword());
        user.setRole(Role.USER);

        int id = userRepository.findByEmail(email).get().getId();

        return new AddUserResponse(id, email);
    }


    public Optional<String> getFirstName(int id) {
        Optional<User> optionalUser = this.userRepository.findById(id);
        if (optionalUser.isEmpty()) {
            return Optional.empty();
        }
        User user = optionalUser.get();
        return Optional.of(user.getFirstname());
    }

    public Optional<String> getFirstName(String email) {
        Optional<User> optionalUser = this.userRepository.findByEmail(email);
        if (optionalUser.isEmpty()) {
            return Optional.empty();
        }
        User user = optionalUser.get();
        return Optional.of(user.getFirstname());
    }

    public Optional<String> getLastName(int id) {
        Optional<User> optionalUser = this.userRepository.findById(id);
        if (optionalUser.isEmpty()) {
            return Optional.empty();
        }
        User user = optionalUser.get();
        return Optional.of(user.getLastname());
    }

    public Optional<String> getLastName(String email) {
        Optional<User> optionalUser = this.userRepository.findByEmail(email);
        if (optionalUser.isEmpty()) {
            return Optional.empty();
        }
        User user = optionalUser.get();
        return Optional.of(user.getLastname());
    }

    public Optional<String> getFullName(int id) {
        Optional<User> optionalUser = this.userRepository.findById(id);
        if (optionalUser.isEmpty()) {
            return Optional.empty();
        }
        User user = optionalUser.get();
        return Optional.of(user.getFirstname() + " " + user.getLastname());
    }

    public Optional<String> getFullName(String email) {
        Optional<User> optionalUser = this.userRepository.findByEmail(email);
        if (optionalUser.isEmpty()) {
            return Optional.empty();
        }
        User user = optionalUser.get();
        return Optional.of(user.getFirstname() + " " + user.getLastname());
    }

    public String getEmailFromToken(String authorizationHeader) {
        String email = jwtService.extractUsername(authorizationHeader.substring(7));
        return email;
    }
    public int getIdFromToken(String authorizationHeader) {
        String email = jwtService.extractUsername(authorizationHeader.substring(7));
        User user = userRepository.findByEmail(email).get();
        return user.getId();
    }

    public String sayHello(String authorizationHeader) {
        String email = getEmailFromToken(authorizationHeader);
        User user = userRepository.findByEmail(email).get();
        return ("Hello from our API, " + user.getFirstname() + " " + user.getLastname() + "!");
    }
}