package com.bookstore.Trabalho.Programacao3.repository;

import com.bookstore.Trabalho.Programacao3.document.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User,String> {

    User findUserByUserName(String name);
    User findUserByEmail(String email);
}
