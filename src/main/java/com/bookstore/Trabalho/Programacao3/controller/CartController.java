package com.bookstore.Trabalho.Programacao3.controller;

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


    @PutMapping("/add/book/id/{cartId}")
    @ApiOperation(value = "Adiciona um livro específico do carrinho de compras")
    ResponseEntity<?> addBook(@PathVariable("cartId") String cartId,@RequestBody ShoppingCartRequest dto);


    @PutMapping("/remove/book/id/{cartId}/position/{position}")
    @ApiOperation(value = "Remove um livro específico do carrinho de compras")
    ResponseEntity<?> removeBook(@PathVariable("cartId") String cartId,@PathVariable("position") int position);

    @DeleteMapping("delete/{cartId}")
    ResponseEntity<?> deleteShoppingCart(@PathVariable("cartId") String cartId);
}
