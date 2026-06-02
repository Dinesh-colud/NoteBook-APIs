package com.dinesh.notebookAPI.serviceImpl;

import com.dinesh.notebookAPI.entity.Note;
import com.dinesh.notebookAPI.repository.NoteRepository;
import com.dinesh.notebookAPI.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class NoteServiceImpl implements NoteService {

    @Autowired
    private NoteRepository noteRepository;

    @Override
    public Note createNote(Note note) {
        note.setCreatedAt(LocalDateTime.now());
        note.setUpdatedAt(LocalDateTime.now());
        note.setDeleted(false);
        return noteRepository.save(note);
    }

    @Override
    public List<Note> getAllNote() {
        return noteRepository.findAll();
    }

    @Override
    public Optional<Note> getSingleNote(Long id) {

        return Optional.of(noteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Id not found: " + id)));
    }

    @Override
    public void deleteNote(Long id) {
        Note note = noteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Id not found: "+id));
        noteRepository.delete(note);
    }

    @Override
    public Note updateNote(Long id, Note newNote) {

        Note exitingNote = noteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Id not found:"+id));

        exitingNote.setTitle(newNote.getTitle());
        exitingNote.setContent(newNote.getContent());

        return noteRepository.save(exitingNote);
    }


}
