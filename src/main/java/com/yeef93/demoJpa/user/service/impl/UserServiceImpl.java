package com.yeef93.demoJpa.user.service.impl;

import com.yeef93.demoJpa.exceptions.DataNotFoundException;
import com.yeef93.demoJpa.user.entity.User;
import com.yeef93.demoJpa.user.repository.UserRepository;
import com.yeef93.demoJpa.user.service.UserService;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Log
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getUser() {
        return  userRepository.findAll();
    }

    @Override
    public Optional<User> getUser(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw new DataNotFoundException("User with ID " + id + " not found.");
        }
        return user;
    }

    @Override
    public User createUser(User user) {
        if (userRepository.existsById(user.getId())) {
            throw new DataNotFoundException("User with ID " + user.getId() + " already exists.");
        }
        return userRepository.save(user);

    }
}
