package com.bookstore.Trabalho.Programacao3.service.impl;

import com.bookstore.Trabalho.Programacao3.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
class UserServiceImplTest {

    @InjectMocks
    private  UserServiceImpl userService;

    @Mock
    private UserRepository userMock;



    @Test
    void findUsers() {
    }



    @Test
    void findUserById() {
    }

    @Test
    void findUserByEmail() {
    }

    @Test
    void createNewUser() {
    }

    @Test
    void updateUserById() {
    }

    @Test
    void deleteUserById() {
    }

    @Test
    void checkIfUserAlreadyExists() {
    }

    @Test
    void checkIfUserIsNotNull() {
    }
}