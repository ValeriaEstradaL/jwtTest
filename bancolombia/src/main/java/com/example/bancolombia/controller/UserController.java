package com.example.bancolombia.controller;


import com.example.bancolombia.persistence.User;
import com.example.bancolombia.service.UserService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;




@RestController
@RequestMapping("/users")
public class UserController {


  /*private final AuthenticationManager authenticationManager;
 @Autowired
  private final TokenProvider jwtTokenProvider;
  private final UserService userService;

  public UserController(AuthenticationManager authenticationManager, TokenProvider jwtTokenProvider, UserService userService) {
    this.authenticationManager = authenticationManager;
    this.jwtTokenProvider = jwtTokenProvider;
    this.userService = userService;
  }*/

  @Autowired
  private UserService service;

  @GetMapping
  public List<User> list() {
    return service.findAll();
  }

  @PostMapping ("/register")
  public ResponseEntity<?> create( @RequestBody User user, BindingResult result) {
    if (result.hasFieldErrors()) {
      return validation(result);
    }
    return ResponseEntity.status(HttpStatus.CREATED).body(service.save(user));
  }


  @PostMapping ("/login")
  public ResponseEntity<?> logjn(@RequestBody User user, BindingResult result) {
    if (result.hasFieldErrors()) {
      return validation(result);
    }
    return ResponseEntity.status(HttpStatus.ACCEPTED).body(service.login(user.getEmail(), user.getPassword()));
  }

  /*@PostMapping("/login")
   public ResponseEntity<?> login( @RequestBody User user) {
     Authentication authentication = authenticationManager.authenticate(
         new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword())
     );
     SecurityContextHolder.getContext().setAuthentication(authentication);
     String token = jwtTokenProvider.generateToken((UserDetails) authentication.getPrincipal());
     return ResponseEntity.ok(new JWTAuthenticationResponse(token));
   }*/
  @PutMapping("/update")
  public ResponseEntity<?> update(@RequestBody User user, BindingResult result) {
    if (result.hasFieldErrors()) {
      return validation(result);
    }
    return ResponseEntity.status(HttpStatus.CREATED).body(service.update(user));
  }

  private ResponseEntity<?> validation(BindingResult result) {
    Map<String, String> errors = new HashMap<>();

    result.getFieldErrors().forEach(err -> {
      errors.put(err.getField(), "El campo " + err.getField() + " " + err.getDefaultMessage());
    });
    return ResponseEntity.badRequest().body(errors);
  }
}
