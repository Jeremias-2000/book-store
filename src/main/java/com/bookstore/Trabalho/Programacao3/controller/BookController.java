package com.bookstore.Trabalho.Programacao3.controller;


import com.bookstore.Trabalho.Programacao3.dto.BookDTO;
import com.bookstore.Trabalho.Programacao3.dto.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface BookController {

    @GetMapping("/all")
    ResponseEntity<?> findBooks();

    @GetMapping("/find/id/{bookId}")
    ResponseEntity<?> findBookById(@PathVariable("bookId") String bookId);

    @PostMapping("/save")
    ResponseEntity<?> creteBook(@RequestBody BookDTO dto);

    @PutMapping("/update/id/{bookId}")
    ResponseEntity<?> updateBook(@PathVariable("bookId") String bookId,@RequestBody BookDTO dto);

    @DeleteMapping("/delete/id/{bookId}/")
    ResponseEntity<?> deleteBook(@PathVariable("bookId") String bookId);
}
