package com.bookstore.Trabalho.Programacao3.service.impl;


import com.bookstore.Trabalho.Programacao3.document.User;
import com.bookstore.Trabalho.Programacao3.document.auth.Login;
import com.bookstore.Trabalho.Programacao3.dto.request.ShoppingCartOperationRequest;
import com.bookstore.Trabalho.Programacao3.dto.request.UserRequest;
import com.bookstore.Trabalho.Programacao3.exception.*;
import com.bookstore.Trabalho.Programacao3.mapper.UserMapper;
import com.bookstore.Trabalho.Programacao3.repository.UserRepository;
import com.bookstore.Trabalho.Programacao3.service.AbstractUserService;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
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
    private PasswordEncoder encoder;

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
    public UserRequest authenticateUser(Login login) {
        boolean valid = false;
        UserRequest response = UserMapper.mapToDTO(userRepository.findUserByEmail(login.getEmail()));
        if (response.equals(null)){
            throw new ExceptionForEmailNotFound("Email does not existes"+ login.getEmail());
        }
        valid = encoder.matches(login.getPassword(), response.getPassword());
        if (!valid){
            throw new ExceptionForUnauthorizedAuthentication("Unauthorized authentication" + login);
        }
         return response;
    }

    @Override
    public UserRequest createNewUser(UserRequest user) {
        checkIfUserIsNotNull(ofNullable(user));
        checkIfUserAlreadyExists(user);
        user.setPassword(encoder.encode(user.getPassword()));

        userRepository.save(UserMapper.mapToModel(user));
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
