package com.bookstore.Trabalho.Programacao3.repository;

import com.bookstore.Trabalho.Programacao3.document.UserFavorite;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserFavoriteRepository extends MongoRepository<UserFavorite,String> {
}
