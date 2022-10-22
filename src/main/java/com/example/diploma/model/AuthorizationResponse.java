package com.example.diploma.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class AuthorizationResponse implements Serializable {

    @Serial
    private static final long serialVersionUID = 8626253L;

    @JsonProperty("auth-token")
    private String authToken;
}
