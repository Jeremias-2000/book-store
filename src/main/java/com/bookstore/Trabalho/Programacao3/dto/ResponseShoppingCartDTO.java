package com.bookstore.Trabalho.Programacao3.dto;

import com.bookstore.Trabalho.Programacao3.document.Book;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseShoppingCartDTO {

    private String cartId;
    private String userId;
    private List<Book> books;
}