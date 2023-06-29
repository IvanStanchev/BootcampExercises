package com.example.springsecuritytutorial.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepositoryMySQL implements UserRepository{

        private final UserDAO userDAO;

        @Autowired
        public UserRepositoryMySQL(UserDAO userDAO) {
            this.userDAO = userDAO;
        }

        @Override
        public Optional<User> findById(Integer id) {
            return userDAO.findById(id);
        }
        @Override
        public Optional<User> findByEmail(String email) {
            return userDAO.findByEmail(email);
        }

        @Override
        public List<User> findAll() {
            return userDAO.findAll();
        }

        @Override
        public void save(User user) {
            userDAO.save(user);
        }

        @Override
        public void update(User user) {
            userDAO.update(user);
        }

        @Override
        public void deleteById(Integer id) {
            userDAO.deleteById(id);
        }
    }

