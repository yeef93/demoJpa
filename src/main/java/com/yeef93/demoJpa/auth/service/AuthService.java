package com.yeef93.demoJpa.auth.service;

import org.springframework.security.core.Authentication;

public interface AuthService {
  String generateToken(Authentication authentication);
}
