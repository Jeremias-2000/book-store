package com.bookstore.Trabalho.Programacao3.mapper;

import com.bookstore.Trabalho.Programacao3.document.ShoppingCart;
import com.bookstore.Trabalho.Programacao3.dto.request.ShoppingCartOperationRequest;

public class ShoppingCartMapper {


    public static ShoppingCart mapToModel(ShoppingCartOperationRequest dto){
        return ShoppingCart.builder()
                .cartId(dto.getCartId())
                .userId(dto.getUserId())
                .books(dto.getBooks())
                .build();
    }

    public static ShoppingCartOperationRequest mapToDTO(ShoppingCart cart){
        return ShoppingCartOperationRequest.builder()
                .cartId(cart.getCartId())
                .userId(cart.getUserId())
                .books(cart.getBooks())
                .build();
    }
}
