package com.bookstore.Trabalho.Programacao3.service;


import com.bookstore.Trabalho.Programacao3.dto.request.UserRequest;

import java.util.List;
import java.util.Optional;

public interface AbstractUserService<U> {

    List<U> findUsers();

    U findUserById(String userId);
    U findUserByEmail(String email);
    U createNewUser(U user);
    U updateUserById(String userId, UserRequest dto);

    void deleteUserById(String userId);

    void checkIfUserAlreadyExists(UserRequest dto);
    void checkIfUserIsNotNull(Optional<UserRequest> dto);
}
