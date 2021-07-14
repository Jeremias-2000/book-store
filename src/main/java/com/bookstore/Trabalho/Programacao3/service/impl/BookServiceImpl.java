package com.bookstore.Trabalho.Programacao3.service.impl;


import com.bookstore.Trabalho.Programacao3.dto.request.BookRequest;
import com.bookstore.Trabalho.Programacao3.exception.BookNotFounException;
import com.bookstore.Trabalho.Programacao3.exception.ExceptionByNullBook;

import com.bookstore.Trabalho.Programacao3.mapper.BookMapper;

import com.bookstore.Trabalho.Programacao3.repository.BookRepository;
import com.bookstore.Trabalho.Programacao3.service.AbstractBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Optional.*;

@Service
public class BookServiceImpl implements AbstractBookService<BookRequest> {

    @Autowired
    private BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<BookRequest> findBooks() {
        return bookRepository.findAll()
                .stream().map(BookMapper::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public BookRequest findBookById(String bookId) {
        return bookRepository.findById(bookId)
                .map(BookMapper::mapToDTO)
                .orElseThrow(() ->
                        new BookNotFounException("The book does not exists" + bookId));
    }

    @Override
    public List<BookRequest> findBookByName(String name) {
        return bookRepository.findByName(name)
                .stream().map(BookMapper::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public BookRequest createBook(BookRequest dto) {
         checkIfBookIsNull(ofNullable(dto));
         checkIfBookAlreadyRegistered(dto);
         bookRepository.save(BookMapper.mapToModel(dto));
         return dto;
    }

    @Override
    public BookRequest updateBook(String bookId, BookRequest dto) {
        bookRepository.findById(bookId)
                .map(book -> BookMapper.mapToModel(dto));
        return dto;
    }

    @Override
    public void deleteBook(String bookId) {
        BookRequest dto = findBookById(bookId);
        bookRepository.delete(BookMapper.mapToModel(dto));
    }

    @Override
    public void checkIfBookIsNull(Optional<BookRequest> bookDTO) {
        if (!bookDTO.isPresent()){
            throw new ExceptionByNullBook("the book is null" + bookDTO);
        }
    }

    @Override
    public void checkIfBookAlreadyRegistered(BookRequest book) {

    }
}
