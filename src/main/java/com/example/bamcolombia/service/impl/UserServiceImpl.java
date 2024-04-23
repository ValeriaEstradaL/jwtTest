package com.example.bamcolombia.service.impl;

import com.example.bamcolombia.dao.request.RegisterRequest;
import com.example.bamcolombia.entities.User;
import com.example.bamcolombia.repository.UserRepository;
import com.example.bamcolombia.service.UserService;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
  private final UserRepository userRepository;
  @Override
  public UserDetailsService userDetailsService() {
    return new UserDetailsService() {
      @Override
      public UserDetails loadUserByUsername(String username) {
        return userRepository.findByEmail(username)
            .orElseThrow(() -> new UsernameNotFoundException("User not found"));
      }
    };
  }

  @Override
  public List<User> getAllUsers() {
    return userRepository.findAll();
  }

  @Override
  public User udpdateUser(Integer id, RegisterRequest request) {
    Optional<User> userById = userRepository.findById(id);

    if( userById.isPresent()){
      User userResult = userById.get();
      userResult.setFirstName(request.getFirstName());
      userResult.setLastName(request.getLastName());
      userResult.setEmail(request.getEmail());
      return userRepository.save(userResult);
    }

    return null;
  }
}
