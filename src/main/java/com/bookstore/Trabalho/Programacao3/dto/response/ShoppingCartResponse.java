package com.bookstore.Trabalho.Programacao3.dto.response;

import com.bookstore.Trabalho.Programacao3.document.Book;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ShoppingCartResponse {

    @NotEmpty
    @NotBlank
    private String cartId;
    @NotEmpty
    @NotBlank
    private String userId;
    private List<Book> books;
}
