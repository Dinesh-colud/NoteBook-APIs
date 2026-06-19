package com.dinesh.notebookAPI.controller;

import com.dinesh.notebookAPI.AuthenticationDTO.LoginRequest;
import com.dinesh.notebookAPI.AuthenticationDTO.SignupRequest;
import com.dinesh.notebookAPI.security.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<String> register(@RequestBody SignupRequest request){

        return ResponseEntity.ok(authService.requestUser(request));
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest request){

        return ResponseEntity.ok(authService.loginRequest(request));
    }

}
