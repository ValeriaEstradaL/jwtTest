package com.example.bamcolombia.controller;

import com.example.bamcolombia.dao.request.RegisterRequest;
import com.example.bamcolombia.entities.User;
import com.example.bamcolombia.service.UserService;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class AuthorizationController {
  private final UserService userService;


  @GetMapping
  public ResponseEntity<List<User>> getUsers() {
    return ResponseEntity.ok(userService.getAllUsers());
  }

  @PutMapping("/update")
  public ResponseEntity<User> updateUsers(@PathVariable Integer id, @RequestBody RegisterRequest request) {
    return ResponseEntity.ok(userService.udpdateUser(id,request));
  }
}
