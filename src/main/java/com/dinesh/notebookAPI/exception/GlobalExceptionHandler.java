package com.dinesh.notebookAPI.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // Handle custom Exception
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?> handleResourceNotFound(RuntimeException ex){

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(ex.getMessage());
    }
    //Generic Exception Handler
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleExceptionGeneric(Exception ex){

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("Something went wrong"+ex.getMessage());
    }
}