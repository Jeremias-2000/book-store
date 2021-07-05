package com.bookstore.Trabalho.Programacao3.controller.impl;


import com.bookstore.Trabalho.Programacao3.controller.BookController;
import com.bookstore.Trabalho.Programacao3.dto.BookDTO;
import com.bookstore.Trabalho.Programacao3.service.impl.BookServiceImpl;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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
        return null;
    }

    @Override
    public ResponseEntity<?> creteBook(BookDTO dto) {
        return null;
    }

    @Override
    public ResponseEntity<?> updateBook(String bookId, BookDTO dto) {
        return null;
    }

    @Override
    public ResponseEntity<?> deleteBook(String bookId) {
        return null;
    }
}
