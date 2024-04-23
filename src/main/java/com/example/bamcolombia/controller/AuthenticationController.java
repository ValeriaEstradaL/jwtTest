package com.example.bamcolombia.controller;

import com.example.bamcolombia.dao.request.LoginRequest;
import com.example.bamcolombia.dao.request.RegisterRequest;
import com.example.bamcolombia.dao.response.JwtAuthenticationResponse;
import com.example.bamcolombia.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
  private final AuthenticationService authenticationService;
  @PostMapping("/signup")
  public ResponseEntity<JwtAuthenticationResponse> signup(@RequestBody RegisterRequest request) {
    return ResponseEntity.ok(authenticationService.signup(request));
  }

  @PostMapping("/signin")
  public ResponseEntity<JwtAuthenticationResponse> signin(@RequestBody LoginRequest request) {
    return ResponseEntity.ok(authenticationService.signin(request));
  }
}
