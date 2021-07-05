package com.bookstore.Trabalho.Programacao3.controller.impl;

import com.bookstore.Trabalho.Programacao3.controller.CartController;
import com.bookstore.Trabalho.Programacao3.dto.user.ShoppingCartDTO;
import com.bookstore.Trabalho.Programacao3.service.impl.CartServiceImpl;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/cart")
@Api("Shopping Cart")
@CrossOrigin(value = "*")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ShoppingCartControllerImpl implements CartController {

    private CartServiceImpl cartService;


    @Override
    public ResponseEntity<?> findShoppingCarts() {
        return ResponseEntity.ok(cartService.findShoppingCarts());
    }

    @Override
    public ResponseEntity<?> createShoppingCart(ShoppingCartDTO dto) {
        return new ResponseEntity<>(cartService.createShoppingCart(dto), HttpStatus.CREATED);
    }
}
