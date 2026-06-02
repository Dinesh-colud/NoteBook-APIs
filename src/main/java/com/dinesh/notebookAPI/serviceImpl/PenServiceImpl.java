package com.dinesh.notebookAPI.serviceImpl;

import com.dinesh.notebookAPI.entity.Pen;
import com.dinesh.notebookAPI.repository.PenRepository;
import com.dinesh.notebookAPI.service.PenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.module.ResolutionException;
import java.util.List;

@Service
public class PenServiceImpl implements PenService {

    @Autowired
    private PenRepository penRepository;

    @Override
    public Pen createPen(Pen pen) {

        return penRepository.save(pen);
    }

    @Override
    public Pen getSinglePen(Long penId) {

        return penRepository.findById(penId)
                .orElseThrow(() -> new RuntimeException("Pen not found with id: "+penId));
    }

    @Override
    public List<Pen> getAllPens() {

        return penRepository.findAll();
    }

    @Override
    public void deletePenById(Long penId) {
        Pen pen = penRepository.findById(penId)
                .orElseThrow(() -> new RuntimeException("Not found id: "+penId));
        penRepository.delete(pen);
    }

}
