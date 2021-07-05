package com.bookstore.Trabalho.Programacao3.document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ShoppingCart {

    @Id
    private String cartId;
    private String userId;
    private List<Book> books;
}
