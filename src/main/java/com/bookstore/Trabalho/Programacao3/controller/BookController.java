package com.bookstore.Trabalho.Programacao3.controller;


import com.bookstore.Trabalho.Programacao3.dto.BookDTO;
import com.bookstore.Trabalho.Programacao3.dto.UserDTO;
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

    @PostMapping("/save")
    @ApiOperation(value = "salva um livro")
    ResponseEntity<?> creteBook(@RequestBody BookDTO dto);

    @PutMapping("/update/id/{bookId}")
    @ApiOperation(value = "atualiza um livro")
    ResponseEntity<?> updateBook(@PathVariable("bookId") String bookId,@RequestBody BookDTO dto);

    @DeleteMapping("/delete/id/{bookId}/")
    @ApiOperation(value = "deleta um livro")
    ResponseEntity<?> deleteBook(@PathVariable("bookId") String bookId);
}
