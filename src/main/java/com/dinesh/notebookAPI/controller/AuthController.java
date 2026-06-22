package com.dinesh.notebookAPI.controller;

import com.dinesh.notebookAPI.AuthenticationDTO.LoginRequest;
import com.dinesh.notebookAPI.AuthenticationDTO.SignupRequest;
import com.dinesh.notebookAPI.security.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signup")
    @Tag(name = "Auth APIs", description = "Operations related to authentication")
    @Operation(description = "Sign-up", summary = "API to user signup")
    public ResponseEntity<String> register(@RequestBody SignupRequest request){

        return ResponseEntity.ok(authService.requestUser(request));
    }

    @PostMapping("/login")
    @Tag(name = "Auth APIs", description = "Operations related to authentication")
    @Operation(description = "Log-in", summary = "API to user log-in")
    public ResponseEntity<String> login(@RequestBody LoginRequest request){

        return ResponseEntity.ok(authService.loginRequest(request));
    }

}
