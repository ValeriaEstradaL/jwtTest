package com.example.bancolombia.service;

import com.example.bancolombia.persistence.User;
import com.example.bancolombia.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class JpaUsers implements UserDetailsService {

  @Autowired
  private UserRepository repository;

  @Transactional(readOnly = true)
  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

    Optional<User> userOptional = Optional.ofNullable(repository.findByUsername(username));

    if (userOptional.isEmpty()) {
      throw new UsernameNotFoundException(String.format("Username %s no existe en el sistema!", username));
    }

    User user = userOptional.orElseThrow();

    return new org.springframework.security.core.userdetails.User(user.getUsername(),
        user.getPassword(),
        true,
        true,
        true,
        true, null
        );
  }
}

