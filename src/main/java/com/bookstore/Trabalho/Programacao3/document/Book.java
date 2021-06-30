package com.bookstore.Trabalho.Programacao3.document;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @Id
    private String bookId;
    private String name;
    private String description;
    private String author;
    private Date launchData;
    private String price;
}
