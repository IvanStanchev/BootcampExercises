package com.example.springsecuritytutorial.note;

import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public interface NoteRepository {
    public void save(Note note);

    public Optional<Note> getById(Long id);

    public List<Note> getByUserId(int userId);

    public void update(Note note);

    public void delete(Long id);
}
