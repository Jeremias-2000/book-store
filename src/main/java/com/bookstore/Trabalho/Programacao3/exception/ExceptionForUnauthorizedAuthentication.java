package com.bookstore.Trabalho.Programacao3.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class ExceptionForUnauthorizedAuthentication extends RuntimeException {
    public ExceptionForUnauthorizedAuthentication(String message) {
    }
}
