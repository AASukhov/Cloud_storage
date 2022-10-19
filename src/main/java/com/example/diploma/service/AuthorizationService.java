package com.example.diploma.service;

import com.example.diploma.model.AuthorizationRequest;
import com.example.diploma.repository.AuthorizationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AuthorizationService {
    AuthorizationRepository repository;

    public AuthorizationRepository logIn(AuthorizationRequest request){
        return null;
    }

    public AuthorizationRepository logOut(AuthorizationRequest request) {
        return null;
    }
}
