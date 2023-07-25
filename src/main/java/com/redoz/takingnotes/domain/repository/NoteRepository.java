package com.redoz.takingnotes.domain.repository;

import com.redoz.takingnotes.domain.Note;

import java.util.List;
import java.util.Optional;

public interface NoteRepository {
    List<Note> getAll();
    Optional<Note> getNote(int id);
    Note save(Note note);
    boolean delete(int id);
}
