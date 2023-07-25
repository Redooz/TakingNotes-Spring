package com.redoz.takingnotes.persistence;

import com.redoz.takingnotes.domain.Note;
import com.redoz.takingnotes.domain.repository.NoteRepository;
import com.redoz.takingnotes.persistence.crud.NoteCrudRepository;
import com.redoz.takingnotes.persistence.entity.NoteEntity;
import com.redoz.takingnotes.persistence.mapper.NoteMapper;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class NoteRepositoryImpl implements NoteRepository {
    private final NoteCrudRepository noteCrudRepository;
    private final NoteMapper noteMapper;

    public NoteRepositoryImpl(NoteCrudRepository noteCrudRepository, NoteMapper noteMapper) {
        this.noteCrudRepository = noteCrudRepository;
        this.noteMapper = noteMapper;
    }

    @Override
    public List<Note> getAll() {
        return noteMapper.toNotes((List<NoteEntity>) noteCrudRepository.findAll());
    }

    @Override
    public Optional<Note> getNote(int id) {
        Optional<NoteEntity> noteEntity = noteCrudRepository.findById(id);

        return noteEntity.map(note -> noteMapper.toNote(note));
    }

    @Override
    public Note save(Note note) {
        var noteEntity = noteMapper.toNoteEntity(note);

        return noteMapper.toNote(noteCrudRepository.save(noteEntity));
    }

    @Override
    public boolean delete(int id) {
        try {
            noteCrudRepository.deleteById(id);
            return true; // Deletion successful
        } catch (EmptyResultDataAccessException ex) {
            // Entity with the given ID was not found, so deletion failed
            return false;
        }
    }

}
