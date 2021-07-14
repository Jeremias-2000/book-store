package com.bookstore.Trabalho.Programacao3.service.impl;


import com.bookstore.Trabalho.Programacao3.document.User;
import com.bookstore.Trabalho.Programacao3.dto.request.ShoppingCartOperationRequest;
import com.bookstore.Trabalho.Programacao3.dto.request.UserRequest;
import com.bookstore.Trabalho.Programacao3.exception.ExceptionByNullUser;
import com.bookstore.Trabalho.Programacao3.exception.ExceptionForEmailNotFound;
import com.bookstore.Trabalho.Programacao3.exception.ExceptionPerExistingUser;
import com.bookstore.Trabalho.Programacao3.exception.UserNotFoundException;
import com.bookstore.Trabalho.Programacao3.mapper.UserMapper;
import com.bookstore.Trabalho.Programacao3.repository.UserRepository;
import com.bookstore.Trabalho.Programacao3.service.AbstractUserService;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Optional.*;


@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserServiceImpl implements AbstractUserService<UserRequest> {


    private UserRepository userRepository;
    private CartServiceImpl cartService;

    @Override
    public List<UserRequest> findUsers() {
        return userRepository.findAll()
                .stream().map(UserMapper::mapToDTO)
                .collect(Collectors.toList());
    }




    @Override
    public UserRequest findUserById(String userId) {
        return userRepository.findById(userId)
                .map(UserMapper::mapToDTO)
                .orElseThrow(() ->
                        new UserNotFoundException("id does not exists" + userId));
    }

    @Override
    public UserRequest findUserByEmail(String email) {
        UserRequest request = UserMapper.mapToDTO( userRepository.findUserByEmail(email));
        if (!request.equals(null)){
            return request;
        }else {
            throw new ExceptionForEmailNotFound("Email does not exists in database " + email );
        }

    }

    @Override
    public UserRequest createNewUser(UserRequest user) {
        checkIfUserIsNotNull(ofNullable(user));
        checkIfUserAlreadyExists(user);
        userRepository.save(UserMapper.mapToModel(user));


        ShoppingCartOperationRequest cartDTO = new ShoppingCartOperationRequest();
        cartDTO.setUserId(user.getUserId());
        cartService.createShoppingCart(cartDTO);

        return user ;
    }

    @Override
    public UserRequest updateUserById(String userId, UserRequest dto) {
        userRepository.findById(userId)
                .map(user -> UserMapper.mapToModel(dto));

         return dto;
    }

    @Override
    public void deleteUserById(String userId) {
        UserRequest dto = findUserById(userId);
        userRepository.delete(UserMapper.mapToModel(dto));
    }

    @Override
    public void checkIfUserAlreadyExists(UserRequest dto) {
        if (dto.getUserName().equals(userRepository.findUserByUserName(dto.getUserName()))){
            throw new ExceptionPerExistingUser("the  user already exists" + dto);
        }
    }

    @Override
    public void checkIfUserIsNotNull(Optional<UserRequest> dto) {
            if (!dto.isPresent()){
                throw  new ExceptionByNullUser("the user is null " +  dto);
            }
    }
}
