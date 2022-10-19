package com.example.diploma.controller;

import com.example.diploma.entity.File;
import com.example.diploma.service.FileService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/file")
public class FileController {
    private FileService service;

    @PostMapping()
    public ResponseEntity<?> uploadFile(@RequestHeader("token") String token, @RequestParam("filename") String filename, MultipartFile file) {
        service.uploadFile(token, filename, file);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping()
    public ResponseEntity<?> deleteFile(@RequestHeader("token") String token, @RequestParam("filename") String filename) {
        service.deleteFile(token, filename);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<?> downloadFile(@RequestHeader("token") String token, @RequestParam("filename") String filename) {
        service.deleteFile(token, filename);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<?> editFileName(@RequestHeader("token") String token, @RequestParam("filename") String filename, @RequestBody FileNameRequest fileNameRequest) {
        service.editFileName(token, filename, fileNameRequest);
        return ResponseEntity.ok(HttpStatus.OK);
    }
    @GetMapping("/all")
    public List<File> getAllFiles(@RequestHeader("token") String  token, @RequestParam("limit") Integer limit) {
        return service.getAllFiles(token, limit);
    }
}

