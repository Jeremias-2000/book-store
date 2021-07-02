package com.bookstore.Trabalho.Programacao3.controller.impl;


import com.bookstore.Trabalho.Programacao3.controller.BookController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/book")
public class BookControllerImpl implements BookController {

    @Override
    public String testeEndpoint() {
        return "<h1>deu certo</h1>";
    }
}
