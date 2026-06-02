package com.dinesh.notebookAPI.controller;

import com.dinesh.notebookAPI.entity.Pen;
import com.dinesh.notebookAPI.service.PenService;
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

    @PostMapping("/pens")
    public ResponseEntity<Pen> createPen(@RequestBody Pen pen){
        Pen pen1 = penService.createPen(pen);
        return new ResponseEntity<>(pen1, HttpStatus.CREATED);
    }

    @GetMapping("/getpen/{penId}")
    public ResponseEntity<Pen> getSinglePen(@PathVariable Long penId){
        Pen pen = penService.getSinglePen(penId);
        return new ResponseEntity<>(pen, HttpStatus.FOUND);
    }

    @GetMapping("/getpens")
    public ResponseEntity<List<Pen>> getAllPens(){
        List<Pen> pens = penService.getAllPens();
        return new ResponseEntity<>(pens, HttpStatus.OK);
    }

    @DeleteMapping("/deletepen/{penId}")
    public ResponseEntity<String> deletePens(@PathVariable Long penId){
        penService.deletePenById(penId);
        return ResponseEntity.ok().body("Note Deleted Successfully!!");
    }

}
