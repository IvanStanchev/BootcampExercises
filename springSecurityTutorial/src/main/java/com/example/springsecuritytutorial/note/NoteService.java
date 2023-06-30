package com.example.springsecuritytutorial.note;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class NoteService {
    private final NoteRepositoryMySQL noteRepository;

    @Autowired
    public NoteService(NoteRepositoryMySQL noteRepository) {
        this.noteRepository = noteRepository;
    }

    public void addNote(String content, int user_id) {
        Note note = new Note();
        note.setContent(content);
        note.setUserId(user_id);
        note.setLastModified(LocalDateTime.now());
        noteRepository.save(note);
    }

    public List<Note> getNotesByUserId(int userId) {
        return noteRepository.getByUserId(userId);
    }
}
