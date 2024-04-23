package com.example.bamcolombia.service;

import com.example.bamcolombia.dao.request.RegisterRequest;
import com.example.bamcolombia.entities.User;
import java.util.List;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService {
  UserDetailsService userDetailsService();
  List<User> getAllUsers();
  User udpdateUser(Integer id, RegisterRequest requets);
}
