package com.dinesh.notebookAPI.service;

import com.dinesh.notebookAPI.dto.PenDTO;
import com.dinesh.notebookAPI.entity.Pen;

import java.util.List;

public interface PenService {
    
    PenDTO createPen(PenDTO penDTO);

    PenDTO getSinglePen(Long penId);

    List<PenDTO> getAllPens();

    void deletePenById(Long penId);

    PenDTO updatePen(Long penId, PenDTO pen);
}
