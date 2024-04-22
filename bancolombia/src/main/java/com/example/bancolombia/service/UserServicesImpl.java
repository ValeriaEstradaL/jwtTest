package com.example.bancolombia.service;

import com.example.bancolombia.persistence.User;
import com.example.bancolombia.repository.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServicesImpl  implements UserService {
  @Autowired
  private UserRepository repository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Override
  @Transactional(readOnly = true)
  public List<User> findAll() {
    return repository.findAll();
  }

  @Override
  @Transactional
  public User save(User user) {
    user.setPassword(passwordEncoder.encode(user.getPassword()));
    return repository.save(user);
  }

  @Override
  @Transactional
  public User update(User user) {
    return repository.save(user);
  }

  @Override
  @Transactional(readOnly = true)
  public User login(String email, String password) {
    return repository.findByEmail(email);
  }
}

