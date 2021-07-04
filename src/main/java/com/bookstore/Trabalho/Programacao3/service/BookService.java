package com.bookstore.Trabalho.Programacao3.service;

import java.util.List;
import java.util.Optional;

public interface BookService<B> {

    List<B> findBooks();
    B findBookById(String bookId);
    B findBookByName(String name);
    B createBook(B book);
    B updateBook(String bookId, B book);
    void deleteBook(String bookId);
    void checkIfBookIsNull(Optional<B> book);
    void checkIfBookAlreadyRegistered(B book);

}
