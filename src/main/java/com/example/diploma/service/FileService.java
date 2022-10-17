package com.example.diploma.service;

import com.example.diploma.repository.FileRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class FileService {
    FileRepository fileRepository;
}
