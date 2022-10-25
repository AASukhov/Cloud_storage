package com.example.diploma.controller;

import com.example.diploma.exceptions.DataException;
import com.example.diploma.exceptions.FileException;
import com.example.diploma.exceptions.UnauthorizedUserException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {

    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(DataException.class)
    public String HandlerInputData (DataException e) {
        return e.getMessage();
    }

    @ResponseStatus(value = HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(UnauthorizedUserException.class)
    public String HandlerUnauthorized (UnauthorizedUserException e) {
        return e.getMessage();
    }

    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(FileException.class)
    public String HandlerFile (FileException e) {
        return e.getMessage();
    }
}
