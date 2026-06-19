package com.dinesh.notebookAPI.security;

import com.dinesh.notebookAPI.AuthenticationDTO.LoginRequest;
import com.dinesh.notebookAPI.AuthenticationDTO.SignupRequest;
import com.dinesh.notebookAPI.entity.User;
import com.dinesh.notebookAPI.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final AuthenticationManager authenticationManager;

    public String requestUser(SignupRequest request){
        if (userRepository.existsByUsername(request.getUsername())){

            return "Username already exists";
        }
        if(userRepository.existsByEmail(request.getEmail())){

            return "Email already exists";
        }

        User user = new User();

        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());

        user.setPassword(passwordEncoder.encode(request.getPassword()));

        userRepository.save(user);

        return "User Registered successfully!";

    }

    public String loginRequest(LoginRequest request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );

        if(authentication.isAuthenticated()){
            return "Login successful";
        }

        return "Login Failed";
    }
}
