package com.dinesh.notebookAPI.repository;

import com.dinesh.notebookAPI.entity.Pen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PenRepository extends JpaRepository<Pen, Long> {

}
