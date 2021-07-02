package com.bookstore.Trabalho.Programacao3.mapper;


import com.bookstore.Trabalho.Programacao3.document.Book;
import com.bookstore.Trabalho.Programacao3.dto.BookDTO;

public class BookMapper {

    public static  Book mapToModel(BookDTO bookDTO){
        return Book.builder()
                .bookId(bookDTO.getBookId())
                .name(bookDTO.getName())
                .description(bookDTO.getDescription())
                .author(bookDTO.getAuthor())
                .launchData(bookDTO.getLaunchData())
                .build();
    }

    public static  BookDTO mapToDTO(Book book){
        return BookDTO.builder()
                .bookId(book.getBookId())
                .name(book.getName())
                .description(book.getDescription())
                .author(book.getAuthor())
                .launchData(book.getLaunchData())
                .build();
    }
}
