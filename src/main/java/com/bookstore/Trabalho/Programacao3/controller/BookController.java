package com.bookstore.Trabalho.Programacao3.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

public interface BookController {

    @GetMapping("/teste")
    String testeEndpoint();
}
