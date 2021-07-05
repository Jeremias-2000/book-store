package com.bookstore.Trabalho.Programacao3.service.impl;

import com.bookstore.Trabalho.Programacao3.dto.user.ShoppingCartDTO;
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
public class CartServiceImpl implements AbstractCartService<List<ShoppingCartDTO>> {


    private ShoppingCartRepository cartRepository;


    @Override
    public List<ShoppingCartDTO> findShoppingCarts() {
        return cartRepository.findAll().stream()
                .map(ShoppingCartMapper::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ShoppingCartDTO createShoppingCart(ShoppingCartDTO dto) {
         cartRepository.save(ShoppingCartMapper.mapToModel(dto));
         return dto;
    }

    @Override
    public ShoppingCartDTO updateShoppingCart(String cartId, List<ShoppingCartDTO> dto) {
        return null;
    }

    @Override
    public void deleteShoppingCartById(String cartId) {

    }
}
