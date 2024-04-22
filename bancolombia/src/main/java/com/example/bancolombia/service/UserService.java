package com.example.bancolombia.service;

import com.example.bancolombia.persistence.User;
import java.util.List;

public interface UserService {
  List<User> findAll();

  User save(User user);

  User update(User user);

  User login(String email, String pass);
}
