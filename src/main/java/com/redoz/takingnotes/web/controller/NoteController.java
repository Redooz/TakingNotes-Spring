package com.redoz.takingnotes.web.controller;

import com.redoz.takingnotes.domain.Note;
import com.redoz.takingnotes.domain.service.NoteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/notes")
public class NoteController {
    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping()
    public ResponseEntity<List<Note>> getAll() {
        return new ResponseEntity<>(noteService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Note>> getNote(@PathVariable("id") int id) {
        if (noteService.getNote(id).isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(noteService.getNote(id), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Note> save(@RequestBody Note note) {
        return new ResponseEntity<>(noteService.save(note), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") int id) {
        if (!noteService.delete(id)) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(HttpStatus.OK);
    }

}
