package com.example.springsecuritytutorial.user;

public class AddUserResponse {
    private int id;
    private String email;

    public AddUserResponse(int id, String email) {
        this.id = id;
        this.email = email;
    }
}
