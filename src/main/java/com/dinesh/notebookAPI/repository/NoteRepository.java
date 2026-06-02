package com.dinesh.notebookAPI.repository;

import com.dinesh.notebookAPI.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note,Long> {

}
