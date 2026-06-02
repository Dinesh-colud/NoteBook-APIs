package com.dinesh.notebookAPI.service;

import com.dinesh.notebookAPI.dto.NoteDTO;
import com.dinesh.notebookAPI.entity.Note;

import java.util.List;
import java.util.Optional;

public interface NoteService {

     NoteDTO createNote(NoteDTO noteDTO);

     List<NoteDTO> getAllNote();

     NoteDTO getSingleNote(Long id);

     void deleteNote(Long id);

     NoteDTO updateNote(Long id, Note newNote);
}
