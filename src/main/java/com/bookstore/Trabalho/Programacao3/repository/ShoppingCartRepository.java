package com.bookstore.Trabalho.Programacao3.repository;

import com.bookstore.Trabalho.Programacao3.document.ShoppingCart;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShoppingCartRepository extends MongoRepository<ShoppingCart,String> {
}
