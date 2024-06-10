package com.yeef93.demoJpa.user.repository;

import com.yeef93.demoJpa.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
