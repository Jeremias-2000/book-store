package com.bookstore.Trabalho.Programacao3.controller;

import com.bookstore.Trabalho.Programacao3.dto.request.CartRequest;
import com.bookstore.Trabalho.Programacao3.dto.request.ShoppingCartRequest;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface CartController {

    @GetMapping("/all")
    ResponseEntity<?> findShoppingCarts();

    @GetMapping("/find/id/{cartId}")
    @ApiOperation(value = "Retorna um livro específico do carrinho de compras")
    ResponseEntity<?> findCartById(@PathVariable("cartId") String cartId);


    @PostMapping("/add/cart/")
    @ApiOperation(value = "Adiciona um livro específico do carrinho de compras")
    ResponseEntity<?> addToCart(@RequestBody ShoppingCartRequest dto);

    @PutMapping("/update/cart/")
    @ApiOperation(value = "Atualiza o carrinho de compras")
    ResponseEntity<?> updateCart(@RequestBody CartRequest request);

    @DeleteMapping("delete/{cartId}")
    ResponseEntity<?> deleteShoppingCart(@PathVariable("cartId") String cartId);
}
