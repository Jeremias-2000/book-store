package com.bookstore.Trabalho.Programacao3.service.impl;


import com.bookstore.Trabalho.Programacao3.document.Book;
import com.bookstore.Trabalho.Programacao3.dto.request.CartRequest;
import com.bookstore.Trabalho.Programacao3.dto.request.ShoppingCartRequest;
import com.bookstore.Trabalho.Programacao3.exception.ExceptionForNullShoppingCart;
import com.bookstore.Trabalho.Programacao3.exception.ExceptionForShoppingCartNotFound;

import com.bookstore.Trabalho.Programacao3.mapper.ShoppingCartMapper;
import com.bookstore.Trabalho.Programacao3.repository.ShoppingCartRepository;
import com.bookstore.Trabalho.Programacao3.service.AbstractCartService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CartServiceImpl implements AbstractCartService<ShoppingCartRequest> {


    private ShoppingCartRepository cartRepository;



    @Override
    public List<ShoppingCartRequest> findShoppingCarts() {
        return cartRepository.findAll().stream()
                .map(ShoppingCartMapper::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ShoppingCartRequest findCartById(String cartId) {
        return cartRepository.findById(cartId).map(ShoppingCartMapper::mapToDTO).orElseThrow(() ->
                new ExceptionForShoppingCartNotFound("shopping cart does not exists: " + cartId));

    }

    @Override
    public ShoppingCartRequest addBookInShoppingCart(ShoppingCartRequest cartDTO) {
        checkIfTheShoppingCartIsNull(cartDTO);
         cartRepository.save(ShoppingCartMapper.mapToModel(cartDTO));
         return cartDTO;
    }

    @Override
    public ShoppingCartRequest updateShoppingCart(CartRequest dto) {
        ShoppingCartRequest request = findCartById(dto.getCartId());
        if(dto.isRemoveItem() == true){
            request.removeBook(dto.getPosition());
        }else{
            request.addBook(dto.getBookRequest());
        }
        return request;
    }

    @Override
    public void deleteShoppingCartById(String cartId) {
         findCartById(cartId);
         cartRepository.deleteById(cartId);
    }


    @Override
    public void checkIfTheShoppingCartIsNull(ShoppingCartRequest dto) {
        if (!dto.equals(null)){
            throw new ExceptionForNullShoppingCart("the shopping cart is null " + dto);
        }
    }
}
