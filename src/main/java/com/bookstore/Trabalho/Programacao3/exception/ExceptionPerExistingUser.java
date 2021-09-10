package com.bookstore.Trabalho.Programacao3.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ExceptionPerExistingUser extends RuntimeException {
    public ExceptionPerExistingUser(String s) {
        super(s);
    }
}
