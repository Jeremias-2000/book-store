package com.bookstore.Trabalho.Programacao3.controller;


import com.bookstore.Trabalho.Programacao3.dto.request.BookRequest;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;


import org.springframework.web.bind.annotation.*;

public interface BookController {

    @GetMapping("/all")

    @ApiOperation(value = "retorna uma lista de livros")
    ResponseEntity<?> findBooks();

    @GetMapping("/find/id/{bookId}")

    @ApiOperation(value = "retorna  livro específico")
    ResponseEntity<?> findBookById(@PathVariable("bookId") String bookId);

    @GetMapping("/find/name/{name}")

    @ApiOperation(value = "Retorna pesquisa de livros")
    ResponseEntity<?> findBookByName(@PathVariable("name") String name);

    @PostMapping("/save")

    @ApiOperation(value = "salva um livro")
    ResponseEntity<?> createBook(@RequestBody BookRequest dto);

    @PutMapping("/update/id/{bookId}")
    @ApiOperation(value = "atualiza um livro")
    ResponseEntity<?> updateBook(@PathVariable("bookId") String bookId,@RequestBody BookRequest dto);

    @DeleteMapping("/delete/id/{bookId}/")

    @ApiOperation(value = "deleta um livro")
    ResponseEntity<?> deleteBook(@PathVariable("bookId") String bookId);
}
