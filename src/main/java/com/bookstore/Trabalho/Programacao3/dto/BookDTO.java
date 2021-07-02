package com.bookstore.Trabalho.Programacao3.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {

    private String bookId;
    @NotEmpty
    private String name;
    @NotEmpty
    private String description;
    @NotEmpty
    private String author;
    @NotEmpty
    private Date launchData;
    @NotEmpty
    private String price;
}
