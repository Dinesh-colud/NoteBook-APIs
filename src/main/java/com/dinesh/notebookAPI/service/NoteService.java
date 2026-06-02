package com.dinesh.notebookAPI.service;

import com.dinesh.notebookAPI.entity.Note;

import java.util.List;
import java.util.Optional;

public interface NoteService {

     Note createNote(Note note);
     List<Note> getAllNote();
     Optional<Note> getSingleNote(Long id);
     void deleteNote(Long id);
     Note updateNote(Long id, Note newNote);
}
