package com.bookstore.Trabalho.Programacao3.service.impl;

import org.assertj.core.api.Assertions;
import com.bookstore.Trabalho.Programacao3.repository.UserRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;



import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(SpringExtension.class)
class UserServiceImplTest {

    @InjectMocks
    private  UserServiceImpl userService;

    @Mock
    private UserRepository userRepositoryMock;

    @BeforeEach
    void setUp(){
        
    }

    @Test
    void findUsers() {
    }



    @Test
    void findUserById_whenSucceful() {
      /*  when(userRepositoryMock.findById(ArgumentMatchers.anyString()))
                .then();
       assertThrows(UserNotFoundException.class,() -> userService.findUserById("test"));*/
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

    @Test
    void testFindUsers() {
    }

    @Test
    void testFindUserById() {
    }

    @Test
    void testCreateNewUser() {
    }

    @Test
    void testUpdateUserById() {
    }

    @Test
    void testDeleteUserById() {
    }

    @Test
    void testCheckIfUserAlreadyExists() {
    }

    @Test
    void testCheckIfUserIsNotNull() {
    }

    @Test
    void checkIfEmailAlreadyExists() {
    }
}