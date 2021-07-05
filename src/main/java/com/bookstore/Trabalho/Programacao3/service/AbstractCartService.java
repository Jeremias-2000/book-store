package com.bookstore.Trabalho.Programacao3.service;

import com.bookstore.Trabalho.Programacao3.dto.user.ShoppingCartDTO;

public interface AbstractCartService<SC> {

    SC findShoppingCarts ();
   ShoppingCartDTO createShoppingCart(ShoppingCartDTO dto);
    ShoppingCartDTO updateShoppingCart(String cartId, SC dto);
    void deleteShoppingCartById(String cartId);

}
