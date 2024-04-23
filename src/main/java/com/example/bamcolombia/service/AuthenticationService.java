package com.example.bamcolombia.service;

import com.example.bamcolombia.dao.request.LoginRequest;
import com.example.bamcolombia.dao.request.RegisterRequest;
import com.example.bamcolombia.dao.response.JwtAuthenticationResponse;

public interface AuthenticationService {
  JwtAuthenticationResponse signup(RegisterRequest request);

  JwtAuthenticationResponse signin(LoginRequest request);
}
