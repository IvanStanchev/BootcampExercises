package com.example.springsecuritytutorial.note;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class NoteRepositoryMySQL implements NoteRepository {
    private final NoteDAO noteDAO;

    @Autowired
    public NoteRepositoryMySQL(NoteDAO noteDAO) {
        this.noteDAO = noteDAO;
    }

    @Override
    public void save(Note note) {
        noteDAO.save(note);
    }

    @Override
    public Optional<Note> getById(Long id) {
        return noteDAO.getById(id);
    }

    @Override
    public List<Note> getByUserId(int userId) {
        return null;
    }

    @Override
    public void update(Note note) {
        noteDAO.update(note);
    }

    @Override
    public void delete(Long id) {
        noteDAO.delete(id);
    }
}
