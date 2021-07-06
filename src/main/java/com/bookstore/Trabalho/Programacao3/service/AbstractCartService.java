package com.bookstore.Trabalho.Programacao3.service;

import com.bookstore.Trabalho.Programacao3.document.Book;
import com.bookstore.Trabalho.Programacao3.dto.RequestShoppingCartDTO;
import com.bookstore.Trabalho.Programacao3.dto.ResponseShoppingCartDTO;
import com.bookstore.Trabalho.Programacao3.dto.user.ShoppingCartDTO;

import java.util.List;

public interface AbstractCartService {

   List<ShoppingCartDTO> findShoppingCarts ();
   ShoppingCartDTO findCartById(String cartId);
   ResponseShoppingCartDTO addBookInShoppingCart(String cartId, RequestShoppingCartDTO dto);
   ShoppingCartDTO removeBookInShoppingCart(String cartId, int positionNumber);
   void deleteShoppingCartById(String cartId);

   void checkIfThePositionIsValid(List<Book> books, int position);
   ShoppingCartDTO createShoppingCart(ShoppingCartDTO cartDTO);

   void checkIfTheShoppingCartIsNull(ShoppingCartDTO dto);
}
