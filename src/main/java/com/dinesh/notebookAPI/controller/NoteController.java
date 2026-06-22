package com.dinesh.notebookAPI.controller;

import com.dinesh.notebookAPI.dto.NoteDTO;
import com.dinesh.notebookAPI.service.NoteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class NoteController {

    @Autowired
    private NoteService noteService;

    private NoteDTO noteDTO;

    @PostMapping("/createNote")
    @Tag(name = "Note APIs", description = "Operations related to notes")
    @Operation(description = "Create", summary = "API to create a notebook")
    public ResponseEntity<NoteDTO> create(@RequestBody NoteDTO noteDTO){

        NoteDTO savedNote = noteService.createNote(noteDTO);

        return ResponseEntity.ok(savedNote);
    }

    @GetMapping("/allNotes")
    @Tag(name = "Note APIs", description = "Operations related to notes")
    @Operation(description = "Get All Notes", summary = "API to get all notes")
    public ResponseEntity<List<NoteDTO>> get(){

        List<NoteDTO> noteDTOs = noteService.getAllNote();

        return ResponseEntity.status(HttpStatus.FOUND).body(noteDTOs);
    }

    @GetMapping("/notes/{id}")
    @Tag(name = "Note APIs", description = "Operations related to notes")
    @Operation(description = "Get Single Note", summary = "API to get single note by id")
    public ResponseEntity<NoteDTO> getSingle(@PathVariable Long id){

        NoteDTO noteDTO = noteService.getSingleNote(id);

        return ResponseEntity.status(HttpStatus.FOUND).body(noteDTO);
    }

    @DeleteMapping("/delete/{id}")
    @Tag(name = "Note APIs", description = "Operations related to notes")
    @Operation(description = "Delete Note", summary = "API to delete note")
    public ResponseEntity<String> deleteSingle(@PathVariable Long id){
        noteService.deleteNote(id);
        return ResponseEntity.ok("Note Deleted Successfully!");
    }

    @PutMapping("/update/{id}")
    @Operation(description = "Update Note", summary = "API to update note")
    @Tag(name = "Note APIs", description = "Operations related to notes")
    public ResponseEntity<NoteDTO> update(@PathVariable Long id, @RequestBody NoteDTO newNote){

        NoteDTO noteDTO = noteService.updateNote(id, newNote);

        return ResponseEntity.status(HttpStatus.OK).body(noteDTO);
    }

}
