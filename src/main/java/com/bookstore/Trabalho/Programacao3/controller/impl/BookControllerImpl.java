package com.bookstore.Trabalho.Programacao3.controller.impl;


import com.bookstore.Trabalho.Programacao3.controller.BookController;
import com.bookstore.Trabalho.Programacao3.dto.request.BookRequest;
import com.bookstore.Trabalho.Programacao3.service.impl.BookServiceImpl;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/book")
@Api(value = "Books")
@CrossOrigin(origins = "*")
public class BookControllerImpl implements BookController {

    @Autowired
    private BookServiceImpl bookService;

    @Override
    public ResponseEntity<?> findBooks() {
        return ResponseEntity.ok(bookService.findBooks());
    }

    @Override
    public ResponseEntity<?> findBookById(String bookId) {
        return ResponseEntity.ok(bookService.findBookById(bookId));
    }

    @Override
    public ResponseEntity<?> findBookByName(String name) {
        return ResponseEntity.ok(bookService.findBookByName(name));
    }

    @Override
    public ResponseEntity<?> createBook(BookRequest dto) {
        return new ResponseEntity<>(bookService.createBook(dto), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> updateBook(String bookId, BookRequest dto) {
        return ResponseEntity.ok(bookService.updateBook(bookId, dto));
    }

    @Override
    public ResponseEntity<?> deleteBook(String bookId) {
        bookService.deleteBook(bookId);
        return ResponseEntity.ok().build();
    }
}
