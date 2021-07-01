package com.bookstore.Trabalho.Programacao3.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {

    private String bookId;
    private String name;
    private String description;
    private String author;
    private Date launchData;
    private String price;
}
