package com.example.diploma.repository;

import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class AuthorizationRepository {
    private final Map<String, String> tokenAndUserName = new ConcurrentHashMap<>();
    public void putTokenAndUsername(String token, String username) {
        tokenAndUserName.put(token, username);
    }

    public String getUserNameByToken(String token) {
        return tokenAndUserName.get(token);
    }

    public void removeTokenAndUsernameByToken(String token) {
        tokenAndUserName.remove(token);
    }
}

