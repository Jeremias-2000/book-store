package com.bookstore.Trabalho.Programacao3.document;


import com.bookstore.Trabalho.Programacao3.enums.BookGenre;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Document
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @Id
    private String bookId;
    private String name;
    private String description;
    private BookGenre genre;
    private String author;
    private Date launchData;
    private double price;
    private int quantity;
}
