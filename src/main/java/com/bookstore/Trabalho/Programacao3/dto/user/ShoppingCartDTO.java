package com.bookstore.Trabalho.Programacao3.dto.user;

import com.bookstore.Trabalho.Programacao3.document.Book;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ShoppingCartDTO {

    private String cartId;
    @NotBlank
    private String userId;
    private List<Book> books;
}
