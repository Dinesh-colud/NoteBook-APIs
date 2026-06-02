package com.dinesh.notebookAPI.controller;

import com.dinesh.notebookAPI.entity.Note;
import com.dinesh.notebookAPI.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class NoteController {

    @Autowired
    private NoteService noteService;

    @PostMapping("createNote")
    public ResponseEntity<Note> create(@RequestBody Note note){
//        Note saveNote = noteService.createNote(note);

        return ResponseEntity.status(HttpStatus.CREATED).
                body(noteService.createNote(note));
    }

    @GetMapping("allNotes")
    public ResponseEntity<List<Note>> get(){

        List<Note> notes = noteService.getAllNote();

        return ResponseEntity.status(HttpStatus.FOUND).body(notes);
    }

    @GetMapping("notes/{id}")
    public ResponseEntity<Optional<Note>> getSingle(@PathVariable Long id){

        Optional<Note> note = noteService.getSingleNote(id);

        return ResponseEntity.status(HttpStatus.FOUND).body(note);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteSingle(@PathVariable Long id){
        noteService.deleteNote(id);
        return ResponseEntity.ok("Note Deleted Successfully!");
    }

    @PutMapping("update/{id}")
    public ResponseEntity<Note> update(@PathVariable Long id,@RequestBody Note newNote){

        Note note = noteService.updateNote(id,newNote);

        return ResponseEntity.status(HttpStatus.OK).body(note);
    }

}
