package com.example.springsecuritytutorial.note;

import com.example.springsecuritytutorial.user.User;
import java.sql.*;
import java.time.LocalDateTime;

public class Note {
    private Long id;
    private LocalDateTime lastModified;
    private String content;
    private int userId;

    public Note() {}

    public Note(Long id, LocalDateTime lastModified, String content, int userId) {
        this.id = id;
        this.lastModified = lastModified;
        this.content = content;
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getLastModified() {
        return lastModified;
    }

    public void setLastModified(LocalDateTime lastModified) {
        this.lastModified = lastModified;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
