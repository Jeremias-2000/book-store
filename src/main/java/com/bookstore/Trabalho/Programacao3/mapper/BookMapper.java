package com.bookstore.Trabalho.Programacao3.mapper;


import com.bookstore.Trabalho.Programacao3.document.Book;
import com.bookstore.Trabalho.Programacao3.dto.request.BookRequest;

public class BookMapper {

    public static  Book mapToModel(BookRequest bookRequest){
        return Book.builder()
                .bookId(bookRequest.getBookId())
                .imageUrl(bookRequest.getImageUrl())
                .name(bookRequest.getName())
                .description(bookRequest.getDescription())
                .genre(bookRequest.getGenre())
                .author(bookRequest.getAuthor())
                .launchData(bookRequest.getLaunchData())
                .quantity(bookRequest.getQuantity())
                .price(bookRequest.getPrice())
                .build();
    }

    public static BookRequest mapToDTO(Book book){
        return BookRequest.builder()
                .bookId(book.getBookId())
                .imageUrl(book.getImageUrl())
                .name(book.getName())
                .description(book.getDescription())
                .genre(book.getGenre())
                .author(book.getAuthor())
                .launchData(book.getLaunchData())
                .quantity(book.getQuantity())
                .price(book.getPrice())
                .build();
    }
}
