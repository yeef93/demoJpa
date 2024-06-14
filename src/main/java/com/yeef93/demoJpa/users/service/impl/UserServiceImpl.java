package com.yeef93.demoJpa.users.service.impl;

import com.yeef93.demoJpa.exceptions.ApplicationException;
import com.yeef93.demoJpa.exceptions.DataNotFoundException;
import com.yeef93.demoJpa.users.dto.RegisterRequestDto;
import com.yeef93.demoJpa.users.entity.Users;
import com.yeef93.demoJpa.users.repository.UserRepository;
import com.yeef93.demoJpa.users.service.UserService;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.Optional;

@Service
@Log
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<Users> findAll() {
        return  userRepository.findAll();
    }

    @Override
    public Optional<Users> getUser(Long id) {
        Optional<Users> user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw new DataNotFoundException("User with ID " + id + " not found.");
        }
        return user;
    }

    @Override
    public Users register(RegisterRequestDto user) {
        if(userRepository.existsByEmail(user.getEmail())){
            throw new DataNotFoundException("User with email " +user.getEmail()+" already exist.");
        }
        Users newUser = user.toEntity();
        var password = passwordEncoder.encode(user.getPassword());
        newUser.setPassword(password);
        return userRepository.save(newUser);
    }

    @Override
    public Users findByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(() -> new ApplicationException("User not found"));
    }
}
