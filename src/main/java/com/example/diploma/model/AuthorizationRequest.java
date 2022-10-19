package com.example.diploma.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthorizationRequest {
    private String login;
    private String password;
}
