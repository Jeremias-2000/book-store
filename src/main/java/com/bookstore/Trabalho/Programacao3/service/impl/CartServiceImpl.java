package com.bookstore.Trabalho.Programacao3.service.impl;

import com.bookstore.Trabalho.Programacao3.document.Book;
import com.bookstore.Trabalho.Programacao3.dto.RequestShoppingCartDTO;
import com.bookstore.Trabalho.Programacao3.dto.ResponseShoppingCartDTO;
import com.bookstore.Trabalho.Programacao3.dto.user.ShoppingCartDTO;
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
    public List<ShoppingCartDTO> findShoppingCarts() {
        return cartRepository.findAll().stream()
                .map(ShoppingCartMapper::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ShoppingCartDTO findCartById(String cartId) {
        return cartRepository.findById(cartId).map(ShoppingCartMapper::mapToDTO).orElseThrow(() ->
                new ExceptionForShoppingCartNotFound("shopping cart does not exists: " + cartId));
    }

    @Override
    public ShoppingCartDTO createShoppingCart(ShoppingCartDTO cartDTO) {
        checkIfTheShoppingCartIsNull(cartDTO);
         cartRepository.save(ShoppingCartMapper.mapToModel(cartDTO));
         return cartDTO;
    }

    @Override
    public ResponseShoppingCartDTO addBookInShoppingCart(String cartId, RequestShoppingCartDTO dto) {
        ShoppingCartDTO search = findCartById(cartId);
        ResponseShoppingCartDTO response = new ResponseShoppingCartDTO();
        Book book = BookMapper.mapToModel(dto.getBookDTO());

        search.add(book);

        response.setUserId(dto.getUserId());
        response.setBooks(search.getBooks());

        return response;
    }

    @Override
    public ShoppingCartDTO removeBookInShoppingCart(String cartId, int position) {
        ShoppingCartDTO search = findCartById(cartId);

        checkIfThePositionIsValid(search.getBooks(),position);
        search.remove(position);

        return search;
    }

    @Override
    public void deleteShoppingCartById(String cartId) {
        ShoppingCartDTO cartDTO = findCartById(cartId);
        cartRepository.delete(ShoppingCartMapper.mapToModel(cartDTO));
    }


    @Override
    public void checkIfThePositionIsValid(List<Book> books, int position) {
        if (position < 0 & position > books.size()){
            throw new IndexOutOfBoundsException("The position "+position+" is not valid");
        }
    }

    @Override
    public void checkIfTheShoppingCartIsNull(ShoppingCartDTO dto) {
        if (!dto.equals(null)){
            throw new ExceptionForNullShoppingCart("the shopping cart is null " + dto);
        }
    }
}
