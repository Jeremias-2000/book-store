package com.bookstore.Trabalho.Programacao3.service.impl;

import com.bookstore.Trabalho.Programacao3.document.Book;
import com.bookstore.Trabalho.Programacao3.dto.request.ShoppingCartRequest;
import com.bookstore.Trabalho.Programacao3.dto.response.ShoppingCartResponse;
import com.bookstore.Trabalho.Programacao3.dto.request.ShoppingCartOperationRequest;
import com.bookstore.Trabalho.Programacao3.exception.ExceptionForNullShoppingCart;
import com.bookstore.Trabalho.Programacao3.exception.ExceptionForShoppingCartNotFound;
import com.bookstore.Trabalho.Programacao3.mapper.BookMapper;
import com.bookstore.Trabalho.Programacao3.mapper.ShoppingCartMapper;
import com.bookstore.Trabalho.Programacao3.repository.ShoppingCartRepository;
import com.bookstore.Trabalho.Programacao3.service.AbstractCartService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CartServiceImpl implements AbstractCartService {


    private ShoppingCartRepository cartRepository;



    @Override
    public List<ShoppingCartOperationRequest> findShoppingCarts() {
        return cartRepository.findAll().stream()
                .map(ShoppingCartMapper::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ShoppingCartOperationRequest findCartById(String cartId) {
        return cartRepository.findById(cartId).map(ShoppingCartMapper::mapToDTO).orElseThrow(() ->
                new ExceptionForShoppingCartNotFound("shopping cart does not exists: " + cartId));
    }

    @Override
    public ShoppingCartOperationRequest createShoppingCart(ShoppingCartOperationRequest cartDTO) {
        checkIfTheShoppingCartIsNull(cartDTO);
         cartRepository.save(ShoppingCartMapper.mapToModel(cartDTO));
         return cartDTO;
    }

    @Override
    public ShoppingCartResponse addBookInShoppingCart(String cartId, ShoppingCartRequest dto) {
        ShoppingCartOperationRequest search = findCartById(cartId);
        ShoppingCartResponse response = new ShoppingCartResponse();
        Book book = BookMapper.mapToModel(dto.getBookRequest());

        search.add(book);

        response.setUserId(dto.getUserId());
        response.setBooks(search.getBooks());

        return response;
    }

    @Override
    public ShoppingCartOperationRequest removeBookInShoppingCart(String cartId, int position) {
        ShoppingCartOperationRequest search = findCartById(cartId);

        checkIfThePositionIsValid(search.getBooks(),position);
        search.remove(position);

        return search;
    }

    @Override
    public void deleteShoppingCartById(String cartId) {
        ShoppingCartOperationRequest cartDTO = findCartById(cartId);
        cartRepository.delete(ShoppingCartMapper.mapToModel(cartDTO));
    }


    @Override
    public void checkIfThePositionIsValid(List<Book> books, int position) {
        if (position < 0 & position > books.size()){
            throw new IndexOutOfBoundsException("The position "+position+" is not valid");
        }
    }

    @Override
    public void checkIfTheShoppingCartIsNull(ShoppingCartOperationRequest dto) {
        if (!dto.equals(null)){
            throw new ExceptionForNullShoppingCart("the shopping cart is null " + dto);
        }
    }
}
