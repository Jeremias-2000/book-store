package com.bookstore.Trabalho.Programacao3.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookItem {

    @Id
    private String bookItemId;
    private String userId;
    private List<Book> books;
}
