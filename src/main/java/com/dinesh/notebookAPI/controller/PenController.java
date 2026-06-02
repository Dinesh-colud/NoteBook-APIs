package com.dinesh.notebookAPI.controller;

import com.dinesh.notebookAPI.dto.PenDTO;
import com.dinesh.notebookAPI.entity.Pen;
import com.dinesh.notebookAPI.service.PenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PenController {

    @Autowired
    private PenService penService;

    private PenDTO penDTO;

    @PostMapping("/pens")
    public ResponseEntity<PenDTO> createPen(@Valid @RequestBody PenDTO penDTO){
        PenDTO pen1 = penService.createPen(penDTO);

        return new ResponseEntity<>(pen1, HttpStatus.CREATED);
    }

    @GetMapping("/getpen/{penId}")
    public ResponseEntity<PenDTO> getSinglePen(@PathVariable Long penId){
        PenDTO pen = penService.getSinglePen(penId);
        return new ResponseEntity<>(pen, HttpStatus.FOUND);
    }

    @GetMapping("/getpens")
    public ResponseEntity<List<PenDTO>> getAllPens(){
        List<PenDTO> pens = penService.getAllPens();
        return ResponseEntity.ok().body(pens);
    }

    @DeleteMapping("/deletepen/{penId}")
    public ResponseEntity<String> deletePens(@PathVariable Long penId){
        penService.deletePenById(penId);
        return ResponseEntity.ok().body("Note Deleted Successfully!!");
    }

    @PutMapping("/updatepen/{penId}")
    public ResponseEntity<PenDTO> updatePen(@PathVariable Long penId,
                                         @RequestBody PenDTO pen){
        PenDTO pen1 = penService.updatePen(penId, pen);

        return new ResponseEntity<>(pen1, HttpStatus.OK);
    }

}
