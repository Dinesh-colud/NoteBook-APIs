package com.dinesh.notebookAPI.service;

import com.dinesh.notebookAPI.entity.Pen;

import java.util.List;

public interface PenService {
    
    Pen createPen(Pen pen);

    Pen getSinglePen(Long penId);

    List<Pen> getAllPens();

    void deletePenById(Long penId);
}
