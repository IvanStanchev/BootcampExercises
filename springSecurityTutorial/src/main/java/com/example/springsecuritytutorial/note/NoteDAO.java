package com.example.springsecuritytutorial.note;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class NoteDAO {
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public NoteDAO(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    public void save(Note note) {
        String sql = "INSERT INTO note (date_created, content, user_id) VALUES (:dateCreated, :content, :userId)";
        Map<String, Object> params = new HashMap<>();
        params.put("dateCreated", Timestamp.valueOf(note.getLastModified()));
        params.put("content", note.getContent());
        params.put("userId", note.getUserId());
        namedParameterJdbcTemplate.update(sql, params);
    }

    public Optional<Note> getById(Long id) {
        String sql = "SELECT * FROM note WHERE id = :id";
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        List<Note> notes = namedParameterJdbcTemplate.query(sql, params, noteRowMapper);
        return notes.isEmpty() ? Optional.empty() : Optional.of(notes.get(0));
    }

    public List<Note> getByUserId(int userId) {
        String sql = "SELECT * FROM note WHERE user_id = :userId";
        Map<String, Object> params = new HashMap<>();
        params.put("user_id", userId);
        List<Note> notes = namedParameterJdbcTemplate.query(sql, params, noteRowMapper);
        return notes;
    }

    public void update(Note note) {
        String sql = "UPDATE note SET date_created = :dateCreated, content = :content, user_id = :userId WHERE id = :id";
        Map<String, Object> params = new HashMap<>();
        params.put("dateCreated", Timestamp.valueOf(note.getLastModified()));
        params.put("content", note.getContent());
        params.put("userId", note.getUserId());
        params.put("id", note.getId());
        namedParameterJdbcTemplate.update(sql, params);
    }

    public void delete(Long id) {
        String sql = "DELETE FROM note WHERE id = :id";
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        namedParameterJdbcTemplate.update(sql, params);
    }

    private final RowMapper<Note> noteRowMapper = (resultSet, rowNum) -> {
        Long noteId = resultSet.getLong("id");
        LocalDateTime dateCreated = resultSet.getTimestamp("date_created").toLocalDateTime();
        String content = resultSet.getString("content");
        int userId = resultSet.getInt("user_id");

        return new Note(noteId, dateCreated, content, userId);
    };
}
