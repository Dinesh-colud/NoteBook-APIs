package com.dinesh.notebookAPI.controller;

import com.dinesh.notebookAPI.dto.NoteDTO;
import com.dinesh.notebookAPI.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NoteController {

    @Autowired
    private NoteService noteService;

    private NoteDTO noteDTO;

    @GetMapping("/dinesh")
    public String hello(){

        return "Hello Dinesh!";
    }

    @PostMapping("/createNote")
    public ResponseEntity<NoteDTO> create(@RequestBody NoteDTO noteDTO){

        NoteDTO savedNote = noteService.createNote(noteDTO);

        return ResponseEntity.ok(savedNote);
    }

    @GetMapping("/allNotes")
    public ResponseEntity<List<NoteDTO>> get(){

        List<NoteDTO> noteDTOs = noteService.getAllNote();

        return ResponseEntity.status(HttpStatus.FOUND).body(noteDTOs);
    }

    @GetMapping("/notes/{id}")
    public ResponseEntity<NoteDTO> getSingle(@PathVariable Long id){

        NoteDTO noteDTO = noteService.getSingleNote(id);

        return ResponseEntity.status(HttpStatus.FOUND).body(noteDTO);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteSingle(@PathVariable Long id){
        noteService.deleteNote(id);
        return ResponseEntity.ok("Note Deleted Successfully!");
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<NoteDTO> update(@PathVariable Long id, @RequestBody NoteDTO newNote){

        NoteDTO noteDTO = noteService.updateNote(id, newNote);

        return ResponseEntity.status(HttpStatus.OK).body(noteDTO);
    }

}
