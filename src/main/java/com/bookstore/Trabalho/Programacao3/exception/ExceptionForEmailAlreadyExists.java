package com.bookstore.Trabalho.Programacao3.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ExceptionForEmailAlreadyExists extends RuntimeException {
    public ExceptionForEmailAlreadyExists(String message) {
        super(message);
    }
}
