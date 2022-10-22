package com.example.diploma.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FileNameResponse {

    @JsonProperty("filename")
    private String fileName;

    @JsonProperty("size")
    private Long size;
}
