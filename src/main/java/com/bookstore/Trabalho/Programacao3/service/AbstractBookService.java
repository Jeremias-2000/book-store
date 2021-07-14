package com.bookstore.Trabalho.Programacao3.service;

import com.bookstore.Trabalho.Programacao3.dto.request.BookRequest;

import java.util.List;
import java.util.Optional;

public interface AbstractBookService<B> {

    List<B> findBooks();
    B findBookById(String bookId);
    List<BookRequest> findBookByName(String name);
    B createBook(B book);
    B updateBook(String bookId, B book);
    void deleteBook(String bookId);
    void checkIfBookIsNull(Optional<B> book);
    void checkIfBookAlreadyRegistered(B book);

}
