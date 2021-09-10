package com.bookstore.Trabalho.Programacao3.mapper;

import com.bookstore.Trabalho.Programacao3.document.ShoppingCart;
import com.bookstore.Trabalho.Programacao3.dto.request.ShoppingCartRequest;

public class ShoppingCartMapper {


    public static ShoppingCart mapToModel(ShoppingCartRequest dto){
        return ShoppingCart.builder()
                .cartId(dto.getCartId())
                .userId(dto.getUserId())
                .books(dto.getBooks())
                .build();
    }

    public static ShoppingCartRequest mapToDTO(ShoppingCart cart){
        return ShoppingCartRequest.builder()
                .cartId(cart.getCartId())
                .userId(cart.getUserId())
                .books(cart.getBooks())
                .build();
    }
}
