package com.bookstore.Trabalho.Programacao3.service;

import com.bookstore.Trabalho.Programacao3.document.Book;
import com.bookstore.Trabalho.Programacao3.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService<Book>{

    @Autowired
    private BookRepository bookRepository;


    @Override
    public List<Book> findBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book findBookById(String bookId) {
        return null;
    }

    @Override
    public Book findBookByName(String name) {
        return null;
    }

    @Override
    public Book createBook(Book book) {
        return null;
    }

    @Override
    public Book updateBook(String bookId,Book book) {
        return null;
    }

    @Override
    public void deleteBook(String bookId) {

    }

    @Override
    public void checkIfBookIsNull(Book book) {

    }

    @Override
    public void checkIfBookAlreadyRegistered(Book book) {

    }
}
