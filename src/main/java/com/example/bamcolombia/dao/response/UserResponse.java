package com.example.bamcolombia.dao.response;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {

  String firstName;
  String lastname;
  String email;
  String role;

}
