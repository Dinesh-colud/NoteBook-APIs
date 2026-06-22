package com.dinesh.notebookAPI.controller;

import com.dinesh.notebookAPI.dto.PenDTO;
import com.dinesh.notebookAPI.service.PenService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pens")
public class PenController {

    @Autowired
    private PenService penService;

    private PenDTO penDTO;

    @PostMapping("/create")
    @Tag(name = "Pen APIs", description = "Operations related to pens")
    @Operation(description = "Create Pen", summary = "API to create note")
    public ResponseEntity<PenDTO> createPen(@Valid @RequestBody PenDTO penDTO){
        PenDTO pen1 = penService.createPen(penDTO);

        return new ResponseEntity<>(pen1, HttpStatus.CREATED);
    }

    @GetMapping("/getpen/{penId}")
    @Tag(name = "Pen APIs", description = "Operations related to pens")
    @Operation(description = "Get Pen", summary = "API to get by id")
    public ResponseEntity<PenDTO> getSinglePen(@PathVariable Long penId){
        PenDTO pen = penService.getSinglePen(penId);
        return new ResponseEntity<>(pen, HttpStatus.FOUND);
    }

    @GetMapping("/getall")
    @Tag(name = "Pen APIs", description = "Operations related to pens")
    @Operation(description = "Get All Pens", summary = "API to get the pens")
    public ResponseEntity<List<PenDTO>> getAllPens(){
        List<PenDTO> pens = penService.getAllPens();
        return ResponseEntity.ok().body(pens);
    }

    @DeleteMapping("/delete/{penId}")
    @Tag(name = "Pen APIs", description = "Operations related to pens")
    @Operation(description = "Delete Pen", summary = "API to delete pen")
    public ResponseEntity<String> deletePens(@PathVariable Long penId){
        penService.deletePenById(penId);
        return ResponseEntity.ok().body("Note Deleted Successfully!!");
    }

    @PutMapping("/update/{penId}")
    @Tag(name = "Pen APIs", description = "Operations related to pens")
    @Operation(description = "Update Pen", summary = "API to update pen")
    public ResponseEntity<PenDTO> updatePen(@PathVariable Long penId,
                                         @RequestBody PenDTO pen){
        PenDTO pen1 = penService.updatePen(penId, pen);

        return new ResponseEntity<>(pen1, HttpStatus.OK);
    }

}
