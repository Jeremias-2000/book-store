package com.bookstore.Trabalho.Programacao3.service.impl;

import com.bookstore.Trabalho.Programacao3.document.Book;
import com.bookstore.Trabalho.Programacao3.dto.BookDTO;
import com.bookstore.Trabalho.Programacao3.mapper.BookMapper;
import com.bookstore.Trabalho.Programacao3.repository.BookRepository;
import com.bookstore.Trabalho.Programacao3.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService<BookDTO> {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<BookDTO> findBooks() {
        return bookRepository.findAll()
                .stream().map(BookMapper::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public BookDTO findBookById(String bookId) {
        return null;
    }

    @Override
    public BookDTO findBookByName(String name) {
        return null;
    }

    @Override
    public BookDTO createBook(BookDTO book) {
        return null;
    }

    @Override
    public BookDTO updateBook(String bookId, BookDTO book) {
        return null;
    }

    @Override
    public void deleteBook(String bookId) {

    }

    @Override
    public void checkIfBookIsNull(BookDTO book) {

    }

    @Override
    public void checkIfBookAlreadyRegistered(BookDTO book) {

    }
}
