package com.bookstore.Trabalho.Programacao3.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ExceptionForEmailNotFound extends RuntimeException {
    public ExceptionForEmailNotFound(String s) {
        super(s);
    }
}
