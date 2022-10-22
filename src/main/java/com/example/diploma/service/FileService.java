package com.example.diploma.service;

import com.example.diploma.entity.File;
import com.example.diploma.entity.User;
import com.example.diploma.exceptions.DataException;
import com.example.diploma.exceptions.UnauthorizedUserException;
import com.example.diploma.repository.AuthorizationRepository;
import com.example.diploma.repository.FileRepository;
import com.example.diploma.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.stream.Collectors;

@Service
@Slf4j
@AllArgsConstructor
public class FileService {
    FileRepository fileRepository;
    AuthorizationRepository authorizationRepository;
    UserRepository userRepository;

    public void uploadFile(String authToken, String filename, MultipartFile file) {
        final User user = getUser(authToken);
        if (user == null) {
            throw new UnauthorizedUserException("Unauthorized user");
        }
        try {
            fileRepository.save(new File(filename, LocalDateTime.now(), file.getSize(), file.getContentType(), file.getBytes(), user));
            log.info("User {} upload file {}", user.getLogin(), filename);
        } catch (IOException e) {
            log.error("Upload file error");
            throw new DataException("Data exception");
        }
    }

    public void deleteFile(String authToken, String filename) {
        final User user = getUser(authToken);
        if (user == null) {
            log.error("Delete file error");
            throw new UnauthorizedUserException("Unauthorized user");
        }
        log.info("User {} delete file {}", user.getLogin(), filename);
        fileRepository.removeByUserAndFileName(user, filename);
    }

    public File downloadFile(String authToken, String filename) {
        final User user = getUser(authToken);
        if (user == null) {
            throw new UnauthorizedUserException("Unauthorized user");
        }
        final File file = fileRepository.findByUserAndFileName(user, filename);
        if (file == null) {
            log.error("Download file error");
            throw new DataException("Data exception");
        }
        //log.info("User {} download file {}", user.getLogin(), filename);
        return file;
    }

    public void editFileName(String authToken, String filename, String newFileName) {
        final User user = getUser(authToken);
        if (user == null) {
            log.error("Edit file error");
            throw new UnauthorizedUserException("Unauthorized user");
        }
        if (newFileName != null) {
            fileRepository.editFileNameByUser(user, filename, newFileName);
            log.info("User {} edit file {}", user.getLogin(), filename);
        } else {
            throw new DataException("Data exception");
        }
    }

    public List<FileResponse> getAllFiles(String authToken, Integer limit) {
        final User user = getUser(authToken);
        if (user == null) {
            //log.error("Get all files error");
            throw new UnauthorizedUserException("Unauthorized user");
        }
        //log.info("User {} get all files", user.getLogin());
        return fileRepository.findAllByUser(user, Sort.by("filename")).stream()
                .map(f -> new FileResponse(f.getFilename(), f.getSize()))
                .collect(Collectors.toList());
    }

    private User getUser(String authToken) {
        if (authToken.startsWith("Bearer ")) {
            authToken = authToken.substring(7);
        }
        final String username = authorizationRepository.getUserNameByToken(authToken);
        return userRepository.findByLogin(username)
                .orElseThrow(() -> new UnauthorizedUserException("Unauthorized user"));
    }
}
