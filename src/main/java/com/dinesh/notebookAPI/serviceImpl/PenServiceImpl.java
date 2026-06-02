package com.dinesh.notebookAPI.serviceImpl;

import com.dinesh.notebookAPI.dto.PenDTO;
import com.dinesh.notebookAPI.entity.Pen;
import com.dinesh.notebookAPI.repository.PenRepository;
import com.dinesh.notebookAPI.service.PenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PenServiceImpl implements PenService {

    @Autowired
    private PenRepository penRepository;

    @Override
    public PenDTO createPen(PenDTO penDTO) {

        Pen pen = new Pen();

        pen.setColor(penDTO.getColor());
        pen.setBrand(penDTO.getBrand());
        pen.setPrice(penDTO.getPrice());
        pen.setType(penDTO.getType());

        Pen pen1 = penRepository.save(pen);

        PenDTO response = new PenDTO();

        response.setId(pen1.getId());
        response.setColor(pen1.getColor());
        response.setBrand(pen1.getBrand());
        response.setPrice(pen1.getPrice());
        response.setType(pen1.getType());

        return response;
    }

    @Override
    public PenDTO getSinglePen(Long penId) {

        Pen pen1 = penRepository.findById(penId)
                .orElseThrow(() -> new RuntimeException("Pen not found with id: "+penId));

        Pen pens = penRepository.save(pen1);

        PenDTO response = new PenDTO();

        response.setId(pens.getId());
        response.setColor(pens.getColor());
        response.setPrice(pens.getPrice());
        response.setBrand(pens.getBrand());
        response.setType(pens.getType());

        return response;

    }

    @Override
    public List<PenDTO> getAllPens() {

        List<Pen> pens = penRepository.findAll();

        return pens.stream().map(pen -> {
            PenDTO dto = new PenDTO();
            dto.setId(pen.getId());
            dto.setColor(pen.getColor());
            dto.setBrand(pen.getBrand());
            dto.setPrice(pen.getPrice());
            dto.setType(pen.getType());

            return dto;
        }).toList();
    }

    @Override
    public void deletePenById(Long penId) {
        Pen pen = penRepository.findById(penId)
                .orElseThrow(() -> new RuntimeException("Not found id: "+penId));
        penRepository.delete(pen);

        PenDTO dto = new PenDTO();
        dto.setId(pen.getId());
        dto.setColor(pen.getColor());
        dto.setBrand(pen.getBrand());
        dto.setPrice(pen.getPrice());
        dto.setType(pen.getType());

    }

    @Override
    public PenDTO updatePen(Long penId, PenDTO pen) {

        Pen pen1 = penRepository.findById(penId)
                .orElseThrow(() -> new RuntimeException("Pen not found with id: "+penId));

        //        pen1.setId(pen.getId());
        pen1.setColor(pen.getColor());
        pen1.setBrand(pen.getBrand());
        pen1.setPrice(pen.getPrice());
        pen1.setType(pen.getType());

        Pen pens = penRepository.save(pen1);

        PenDTO dto = new PenDTO();


        dto.setId(pens.getId());
        dto.setColor(pens.getColor());
        dto.setBrand(pens.getBrand());
        dto.setPrice(pens.getPrice());
        dto.setType(pens.getType());

        return dto;
    }

}
