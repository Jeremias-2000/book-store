package com.bookstore.Trabalho.Programacao3.service.impl;

import com.bookstore.Trabalho.Programacao3.document.Endereco;
import com.bookstore.Trabalho.Programacao3.dto.request.UserRequest;
import com.bookstore.Trabalho.Programacao3.exception.ExceptionPerExistingUser;
import com.bookstore.Trabalho.Programacao3.repository.UserRepository;

import com.bookstore.Trabalho.Programacao3.service.cep.ViaApiService;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;


import java.time.LocalDate;

import static java.util.Optional.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
@ExtendWith(SpringExtension.class)

class UserServiceImplTest {

    @InjectMocks
    private  UserServiceImpl userService;
    @MockBean
    private UserRepository userRepository;
    @MockBean
    private ViaApiService viaCepService;

    private UserRequest request1 ;
    private UserRequest request2;



    @BeforeEach
    void setUp(){
        request1 = new UserRequest("231873","Jose", LocalDate.now(),"joseandrade457",
                "teste2@gmail.com","886.575.360-99",new Endereco("29024-527"),
                LocalDate.now(),LocalDate.now());
         request2 = new UserRequest("231873","Jose", LocalDate.now(),"joseandrade457",
                "teste2@gmail.com","886.575.360-99",new Endereco("02422-260"),
                LocalDate.now(),LocalDate.now());
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
       // when(userService.createNewUser(request1)).thenReturn(request1);
       // assertEquals(userService.createNewUser(request1),request1);
    }
    @Test
    void createNewUserWithUniqueEmail() {
        /*userService.createNewUser(request1);
        assertThrows(ExceptionPerExistingUser.class,()->
                userService.checkIfEmailAlreadyExists(request2.getEmail()));*/
    }

    @Test
    void updateUserById() {

    }

    @Test
    void deleteUserById() {

    }

    @Test
    void checkIfUserAlreadyExists() {
       /* when(userService.createNewUser(request1)).thenReturn(request1);
        assertThrows(ExceptionPerExistingUser.class,()-> userService.checkIfUserAlreadyExists(request2));*/
    }

    @Test
    void checkIfUserIsNull() {
        UserRequest request = null;
        assertThrows(NullPointerException.class,()->
                userService.checkIfUserIsNull(ofNullable(request)));
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
    void checkIfEmailAlreadyExists() {
    }
}