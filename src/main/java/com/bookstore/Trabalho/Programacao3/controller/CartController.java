package com.bookstore.Trabalho.Programacao3.controller;

import com.bookstore.Trabalho.Programacao3.dto.user.ShoppingCartDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface CartController {

    @GetMapping("/all")
    ResponseEntity<?> findShoppingCarts();

    @PostMapping("/save")
    ResponseEntity<?> createShoppingCart(@RequestBody ShoppingCartDTO dto);
}
