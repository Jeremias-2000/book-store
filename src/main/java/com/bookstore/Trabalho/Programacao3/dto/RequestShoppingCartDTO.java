package com.bookstore.Trabalho.Programacao3.dto;

import com.bookstore.Trabalho.Programacao3.document.Book;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
@AllArgsConstructor
public class RequestShoppingCartDTO {

    private String cartId;
    private String userId;
    private BookDTO bookDTO;


}
