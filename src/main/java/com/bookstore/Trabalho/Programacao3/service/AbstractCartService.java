package com.bookstore.Trabalho.Programacao3.service;

import com.bookstore.Trabalho.Programacao3.document.Book;
import com.bookstore.Trabalho.Programacao3.dto.request.ShoppingCartRequest;
import com.bookstore.Trabalho.Programacao3.dto.response.ShoppingCartResponse;
import com.bookstore.Trabalho.Programacao3.dto.request.ShoppingCartOperationRequest;

import java.util.List;

public interface AbstractCartService {

   List<ShoppingCartOperationRequest> findShoppingCarts ();
   ShoppingCartOperationRequest findCartById(String cartId);
   ShoppingCartResponse addBookInShoppingCart(String cartId, ShoppingCartRequest dto);
   ShoppingCartOperationRequest removeBookInShoppingCart(String cartId, int positionNumber);
   void deleteShoppingCartById(String cartId);

   void checkIfThePositionIsValid(List<Book> books, int position);
   ShoppingCartOperationRequest createShoppingCart(ShoppingCartOperationRequest cartDTO);

   void checkIfTheShoppingCartIsNull(ShoppingCartOperationRequest dto);
}
