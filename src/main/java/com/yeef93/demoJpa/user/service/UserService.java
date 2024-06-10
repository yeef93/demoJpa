package com.yeef93.demoJpa.user.service;

import com.yeef93.demoJpa.user.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getUser();
    Optional<User> getUser(Long id);
    User createUser (User user);
}
