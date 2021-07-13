package com.bookstore.Trabalho.Programacao3.controller.auth;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestBody;


public interface AuthController {

    @GetMapping("/login")
    ResponseEntity<?> login(@RequestBody String email,@RequestBody String password);
}
