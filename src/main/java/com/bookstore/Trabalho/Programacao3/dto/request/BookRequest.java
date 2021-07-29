package com.bookstore.Trabalho.Programacao3.dto.request;


import com.bookstore.Trabalho.Programacao3.enums.BookGenre;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookRequest {

    private String bookId;
    @NotEmpty
    @NotBlank
    private String name;
    @NotEmpty
    private String description;
    @NotEmpty
    @NotBlank
    private BookGenre genre;
    @NotEmpty
    @NotBlank
    private String author;
    @NotEmpty
    @NotBlank
    private Date launchData;
    @NotEmpty
    @NotBlank
    private double price;
    @NotBlank
    private int quantity;
}
