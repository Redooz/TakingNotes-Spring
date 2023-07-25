package com.redoz.takingnotes.domain.service;

import com.redoz.takingnotes.domain.Note;
import com.redoz.takingnotes.domain.repository.NoteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoteService {
    private final NoteRepository noteRepository;

    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public List<Note> getAll() {
        return noteRepository.getAll();
    }

    public Optional<Note> getNote(int id) {
        return noteRepository.getNote(id);
    }

    public Note save(Note note) {
        return noteRepository.save(note);
    }

    public boolean delete(int id) {
        return noteRepository.delete(id);
    }
}
