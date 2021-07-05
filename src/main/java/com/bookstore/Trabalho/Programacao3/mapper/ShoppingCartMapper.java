package com.bookstore.Trabalho.Programacao3.mapper;

import com.bookstore.Trabalho.Programacao3.document.ShoppingCart;
import com.bookstore.Trabalho.Programacao3.dto.user.ShoppingCartDTO;

public class ShoppingCartMapper {


    public static ShoppingCart mapToModel(ShoppingCartDTO dto){
        return ShoppingCart.builder()
                .cartId(dto.getCartId())
                .userId(dto.getUserId())
                .books(dto.getBooks())
                .build();
    }

    public static ShoppingCartDTO mapToDTO(ShoppingCart cart){
        return ShoppingCartDTO.builder()
                .cartId(cart.getCartId())
                .userId(cart.getUserId())
                .books(cart.getBooks())
                .build();
    }
}
