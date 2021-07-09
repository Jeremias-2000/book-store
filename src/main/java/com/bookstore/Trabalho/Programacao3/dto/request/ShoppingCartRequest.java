package com.bookstore.Trabalho.Programacao3.dto.request;

import com.bookstore.Trabalho.Programacao3.dto.request.BookRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;


@Data
@Builder
@AllArgsConstructor
public class ShoppingCartRequest {


    private String cartId;
    @NotEmpty
    @NotBlank
    private String userId;
    @NotEmpty
    @NotBlank
    private BookRequest bookRequest;


}
