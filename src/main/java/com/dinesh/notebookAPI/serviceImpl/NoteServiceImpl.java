package com.dinesh.notebookAPI.serviceImpl;

import com.dinesh.notebookAPI.dto.NoteDTO;
import com.dinesh.notebookAPI.entity.Note;
import com.dinesh.notebookAPI.repository.NoteRepository;
import com.dinesh.notebookAPI.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class NoteServiceImpl implements NoteService {

    @Autowired
    private NoteRepository noteRepository;

    @Override
    public NoteDTO createNote(NoteDTO noteDTO) {

        Note note = new Note();

        note.setTitle(noteDTO.getTitle());
        note.setContent(noteDTO.getContent());

        Note savedNote = noteRepository.save(note);

        NoteDTO response = new NoteDTO();

        response.setId(savedNote.getId());
        response.setTitle(savedNote.getTitle());
        response.setContent(savedNote.getContent());

        return response;
    }

    @Override
    public List<NoteDTO> getAllNote() {

        List<Note> notes = noteRepository.findAll();

        return notes.stream().map( note ->  {
             NoteDTO dto = new NoteDTO();
             dto.setId(note.getId());
             dto.setTitle(note.getTitle());
             dto.setContent(note.getContent());

             return dto;
        }).toList();
    }

    @Override
    public NoteDTO getSingleNote(Long id) {

        Note notes = noteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Note not found with id: "+id));

        Note note = noteRepository.save(notes);

        NoteDTO response = new NoteDTO();

        response.setId(note.getId());
        response.setTitle(note.getTitle());
        response.setContent(note.getContent());

        return response;
    }

    @Override
    public void deleteNote(Long id) {
        Note notes = noteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Id not found: "+id));
        noteRepository.delete(notes);

        NoteDTO response = new NoteDTO();
        response.setId(notes.getId());
        response.setTitle(notes.getTitle());
        response.setContent(notes.getContent());

    }

    @Override
    public NoteDTO updateNote(Long id, Note newNote) {

        Note exitingNote = noteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Id not found with id: "+id));

        exitingNote.setTitle(newNote.getTitle());
        exitingNote.setContent(newNote.getContent());

        Note note = noteRepository.save(exitingNote);

        NoteDTO response = new NoteDTO();

        response.setId(note.getId());
        response.setTitle(note.getTitle());
        response.setContent(note.getContent());

        return response;
    }

}
