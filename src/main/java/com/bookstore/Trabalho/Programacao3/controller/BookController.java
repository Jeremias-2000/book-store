package com.bookstore.Trabalho.Programacao3.controller;


import com.bookstore.Trabalho.Programacao3.dto.request.BookRequest;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

public interface BookController {

    @GetMapping("/all")
   // @PreAuthorize("hasAnyRole('ROLE.ADMIN','ROLE_ADMINTRAINEE','ROLE_USER')")
    @ApiOperation(value = "retorna uma lista de livros")
    ResponseEntity<?> findBooks();

    @GetMapping("/find/id/{bookId}")
    //@PreAuthorize("hasAuthority('user:read')")
    @ApiOperation(value = "retorna  livro específico")
    ResponseEntity<?> findBookById(@PathVariable("bookId") String bookId);

    @GetMapping("/find/name/{name}")
    //@PreAuthorize("hasAuthority('user:read')")
    @ApiOperation(value = "Retorna pesquisa de livros")
    ResponseEntity<?> findBookByName(@PathVariable("name") String name);

    @PostMapping("/save")
    //@PreAuthorize("hasAnyRole('ROLE.ADMIN')")
    @ApiOperation(value = "salva um livro")
    ResponseEntity<?> createBook(@RequestBody BookRequest dto);

    @PutMapping("/update/id/{bookId}")
    //@PreAuthorize("hasAnyRole('ROLE.ADMIN')")
    @ApiOperation(value = "atualiza um livro")
    ResponseEntity<?> updateBook(@PathVariable("bookId") String bookId,@RequestBody BookRequest dto);

    @DeleteMapping("/delete/id/{bookId}/")
    //@PreAuthorize("hasAnyRole('ROLE.ADMIN')")
    @ApiOperation(value = "deleta um livro")
    ResponseEntity<?> deleteBook(@PathVariable("bookId") String bookId);
}
