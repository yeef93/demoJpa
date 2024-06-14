package com.yeef93.demoJpa.auth.service;

import com.yeef93.demoJpa.auth.dto.ChangePassRequestDto;
import com.yeef93.demoJpa.users.entity.Users;
import org.springframework.security.core.Authentication;

public interface AuthService {
  String generateToken(Authentication authentication);
}
