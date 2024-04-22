package com.example.bancolombia.security;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class GrantedJSONCreator {
  @JsonCreator
  public GrantedJSONCreator(@JsonProperty("authority") String role){}
}
