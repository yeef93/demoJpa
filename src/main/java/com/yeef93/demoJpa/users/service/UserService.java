package com.yeef93.demoJpa.users.service;

import com.yeef93.demoJpa.users.dto.RegisterRequestDto;
import com.yeef93.demoJpa.users.entity.Users;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<Users> findAll();
    Optional<Users> getUser(Long id);
    Users register(RegisterRequestDto user);
    Users findByEmail(String email);
}
