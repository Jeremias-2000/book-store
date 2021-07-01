package com.bookstore.Trabalho.Programacao3.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookItemDTO {

    private String bookItemId;
    private String bookId;
}
