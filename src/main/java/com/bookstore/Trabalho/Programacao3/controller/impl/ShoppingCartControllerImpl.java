package com.bookstore.Trabalho.Programacao3.controller.impl;

import com.bookstore.Trabalho.Programacao3.controller.CartController;
import com.bookstore.Trabalho.Programacao3.dto.request.CartRequest;
import com.bookstore.Trabalho.Programacao3.dto.request.ShoppingCartRequest;
import com.bookstore.Trabalho.Programacao3.service.impl.CartServiceImpl;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.Cacheable;

import java.util.List;


@RestController
@RequestMapping("/api/v1/cart")
@Api("Shopping Cart")
@CrossOrigin(value = "*")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ShoppingCartControllerImpl implements CartController {

    private CartServiceImpl cartService;


    @Override
    @Cacheable(value = "shopping cart")
    public ResponseEntity<?> findShoppingCarts() {
        List<ShoppingCartRequest> cartRequests = cartService.findShoppingCarts();
        return cartRequests.isEmpty() ? ResponseEntity.notFound().build():ResponseEntity.ok(cartRequests);
    }

    @Override
    @Cacheable("cart id")
    public ResponseEntity<?> findCartById(String cartId) {
        return ResponseEntity.ok(cartService.findCartById(cartId));
    }

    @Override
    public ResponseEntity<?> addToCart( ShoppingCartRequest dto) {
        return ResponseEntity.ok(cartService.addBookInShoppingCart( dto));
    }

    @Override
    public ResponseEntity<?> updateCart(CartRequest request) {
        return null;
    }

    @Override
    @CacheEvict(value = "shopping cart")
    public ResponseEntity<?> deleteShoppingCart(String cartId) {
        cartService.deleteShoppingCartById(cartId);
        return ResponseEntity.ok().build();
    }
}
