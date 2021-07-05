package com.bookstore.Trabalho.Programacao3.service;


import com.bookstore.Trabalho.Programacao3.dto.user.UserDTO;

import java.util.List;
import java.util.Optional;

public interface AbstractUserService<U> {

    List<U> findUsers();

    U findUserById(String userId);
    U createNewUser(U user);
    U updateUserById(String userId, UserDTO dto);

    void deleteUserById(String userId);

    void checkIfUserAlreadyExists(UserDTO dto);
    void checkIfUserIsNotNull(Optional<UserDTO> dto);
}
