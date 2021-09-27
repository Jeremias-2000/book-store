package com.bookstore.Trabalho.Programacao3.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class BookNotFounException extends RuntimeException {
    public BookNotFounException(String s) {
        super(s);
    }
}
