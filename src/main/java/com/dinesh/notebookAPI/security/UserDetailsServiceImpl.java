package com.dinesh.notebookAPI.security;

import com.dinesh.notebookAPI.entity.User;
import com.dinesh.notebookAPI.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username){

        User user = userRepository.findByUsername(username).orElseThrow(() ->
                new UsernameNotFoundException("User Not found: "+username));

        return UserDetailsImpl.build(user);
    }
}
