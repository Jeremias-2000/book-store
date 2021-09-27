package com.bookstore.Trabalho.Programacao3.service;



import com.bookstore.Trabalho.Programacao3.dto.request.UserRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface AbstractUserService<U> {

    Page<U> findUsers(Pageable pageable);

    U findUserById(String userId);

    U createNewUser(U user);
    U updateUserById(String userId, U dto);

    void deleteUserById(String userId);

    void checkIfEmailAlreadyExists(String email);
    void checkIfUserAlreadyExists(U dto);
    void checkIfUserIsNull(Optional<U> dto);
}
