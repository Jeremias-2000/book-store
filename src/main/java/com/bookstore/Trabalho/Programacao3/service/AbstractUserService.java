package com.bookstore.Trabalho.Programacao3.service;

import java.util.List;

public interface AbstractUserService<U> {

    List<U> findUsers();
    U findUserById(String userId);
    U createNewUser(U user);
    U updateUserById(String userId);

    void deleteUserById(String userId);
}
