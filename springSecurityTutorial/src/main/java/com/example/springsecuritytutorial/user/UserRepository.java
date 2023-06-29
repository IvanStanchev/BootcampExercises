package com.example.springsecuritytutorial.user;


import java.util.List;
import java.util.Optional;

public interface UserRepository {

    Optional<User> findById(Integer id);
    Optional<User> findByEmail(String email);

    List<User> findAll();

    void save(User user);

    void update(User user);

    void deleteById(Integer id);
}
