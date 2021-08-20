package com.bookstore.Trabalho.Programacao3.dto.request;

import com.bookstore.Trabalho.Programacao3.document.Book;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CartRequest {
    private String cartId;
    private Book bookRequest;
    private int position;
    private boolean removeItem;
}
