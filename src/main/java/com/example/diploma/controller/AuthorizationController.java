package com.example.diploma.controller;

import com.example.diploma.model.AuthorizationRequest;
import com.example.diploma.model.AuthorizationResponse;
import com.example.diploma.service.AuthorizationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class AuthorizationController {
    private final AuthorizationService service;

    @PostMapping("/login")
    public AuthorizationResponse logIn(@RequestBody AuthorizationRequest request) {
        return service.logIn(request);
    }

    @PostMapping("/logout")
    public ResponseEntity<?> logOut(@RequestHeader ("token") String token) {
        service.logOut(token);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
