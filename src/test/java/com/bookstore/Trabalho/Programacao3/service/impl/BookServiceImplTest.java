package com.bookstore.Trabalho.Programacao3.service.impl;

import com.bookstore.Trabalho.Programacao3.dto.request.BookRequest;
import com.bookstore.Trabalho.Programacao3.dto.request.UserRequest;
import com.bookstore.Trabalho.Programacao3.enums.BookGenre;
import com.bookstore.Trabalho.Programacao3.exception.ExceptionByNullBook;
import com.bookstore.Trabalho.Programacao3.mapper.BookMapper;
import com.bookstore.Trabalho.Programacao3.repository.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;

import static java.util.Optional.ofNullable;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
@ExtendWith(MockitoExtension.class)
@DataMongoTest
class BookServiceImplTest {

    @InjectMocks
    private BookServiceImpl bookService;

    @MockBean
    private BookRepository bookRepository;

    private BookRequest request1;
    private BookRequest request2;

    @BeforeEach
    public void setUp(){
        request1 = new BookRequest("2174582216","https://www.amazon.com.br/divina-comédia-Dante-Alighieri/dp/B086W7RC5X/ref=asc_df_B086W7RC5X/?tag=googleshopp00-20&linkCode=df0&hvadid=379725131710&hvpos=&hvnetw=g&hvrand=1923363285703163615&hvpone=&hvptwo=&hvqmt=&hvdev=c&hvdvcmdl=&hvlocint=&hvlocphy=1031920&hvtargid=pla-911312883493&psc=1&asin=B088GTNZY2&revisionId=&format=2&depth=1",
                "A divina comedia",
                "A Divina Comédia é um poema clássico da literatura italiana e mundial com características épica e teológica, escrito por Dante Alighieri no século XIV período renascentista ",
                BookGenre.LETTER,"Dante Alighieri", LocalDate.of(2020,06,18),43.32,720);
        request2 = new BookRequest("2174582216","https://www.amazon.com.br/divina-comédia-Dante-Alighieri/dp/B086W7RC5X/ref=asc_df_B086W7RC5X/?tag=googleshopp00-20&linkCode=df0&hvadid=379725131710&hvpos=&hvnetw=g&hvrand=1923363285703163615&hvpone=&hvptwo=&hvqmt=&hvdev=c&hvdvcmdl=&hvlocint=&hvlocphy=1031920&hvtargid=pla-911312883493&psc=1&asin=B088GTNZY2&revisionId=&format=2&depth=1",
                "A divina comédia",
                "A Divina Comédia é um poema clássico da literatura italiana e mundial com características épica e teológica, escrito por Dante Alighieri no século XIV período renascentista ",
                BookGenre.LETTER,"Dante Alighieri", LocalDate.of(2020,06,18),103.32,720);
    }


    @Test
    void findBooks() {

}

    @Test
    void findBookById() {
            when(bookRepository.findById("2174582216"))
                    .thenReturn(BookMapper.mapToModel2(request1));
            assertEquals(bookService.findBookById("2174582216"),request1);
            verify(bookRepository,times(1)).findById("2174582216");
    }

    @Test
    void findBookByName() {
    }

    @Test
    void createBook() {
        when(bookService.createBook(request1)).thenReturn(request1);

    }

    @Test
    void updateBook() {
        bookService.updateBook("2174582216",request2);
        assertNotEquals(request1,request2);

    }

    @Test
    void deleteBook() {
        BookRequest book = bookService.createBook(request1);
        bookRepository.deleteById("2174582216");
        assertFalse(bookRepository.findById(book.getBookId()).isPresent());

    }

    @Test
    void checkIfBookIsNull() {
        BookRequest bookRequest = null;
        assertThrows(ExceptionByNullBook.class,
                () -> bookService.checkIfBookIsNull(ofNullable(bookRequest)));
    }

    @Test
    void checkIfBookAlreadyRegistered() {
    }
}