package com.bookstore.Trabalho.Programacao3.dto.request;

import com.bookstore.Trabalho.Programacao3.document.Book;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class UserFavoriteRequest {

    private String userId;
    @NotNull
    private Book book;
}
