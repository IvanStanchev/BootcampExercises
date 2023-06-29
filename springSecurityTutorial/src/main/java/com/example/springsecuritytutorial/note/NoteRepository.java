package com.example.springsecuritytutorial.note;

import com.example.springsecuritytutorial.user.User;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;

import java.util.Optional;
import java.util.function.Function;

public interface NoteRepository extends JpaRepository<Note,Long> {
    Optional<Note> findByCreator(User creator);

}
