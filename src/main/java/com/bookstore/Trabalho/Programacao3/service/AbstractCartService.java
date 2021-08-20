package com.bookstore.Trabalho.Programacao3.service;

import com.bookstore.Trabalho.Programacao3.document.Book;
import com.bookstore.Trabalho.Programacao3.dto.request.CartRequest;
import com.bookstore.Trabalho.Programacao3.dto.request.ShoppingCartRequest;
import org.springframework.data.domain.Page;

import java.util.List;

public interface AbstractCartService<SC> {

   List<SC> findShoppingCarts ();
   SC findCartById(String cartId);
   SC addBookInShoppingCart(SC dto);
   SC updateShoppingCart(CartRequest dto);
   void deleteShoppingCartById(String cartId);
   void checkIfTheShoppingCartIsNull(ShoppingCartRequest dto);
}
