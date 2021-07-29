package com.bookstore.Trabalho.Programacao3.service.impl;


import com.bookstore.Trabalho.Programacao3.document.User;
import com.bookstore.Trabalho.Programacao3.dto.request.UserRequest;
import com.bookstore.Trabalho.Programacao3.exception.*;
import com.bookstore.Trabalho.Programacao3.mapper.UserMapper;
import com.bookstore.Trabalho.Programacao3.repository.UserRepository;
import com.bookstore.Trabalho.Programacao3.service.AbstractUserService;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.bookstore.Trabalho.Programacao3.mapper.UserMapper.*;
import static java.util.Optional.*;


@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserServiceImpl implements AbstractUserService<UserRequest> {


    private UserRepository userRepository;



    @Override
    public Page<UserRequest> findUsers(Pageable pageable) {
       return userRepository.findAll(pageable).map(UserMapper::mapToDTO);

    }



    @Override
    public UserRequest findUserById(String userId) {
        return userRepository.findById(userId)
                .map(UserMapper::mapToDTO)
                .orElseThrow(() ->
                        new UserNotFoundException("id does not exists  ==> " + userId + "\n"));
    }



    @Override
    public UserRequest createNewUser(UserRequest user) {

        checkIfUserIsNotNull(ofNullable(user));
        checkIfUserAlreadyExists(user);
        checkIfEmailAlreadyExists(user.getEmail());

        userRepository.save(mapToModel(user));

        return user ;
    }

    @Override
    public UserRequest updateUserById(String userId, UserRequest dto) {
        userRepository.findById(userId)
                .map(user -> mapToModel(dto));

         return dto;
    }

    @Override
    public void deleteUserById(String userId) {
        findUserById(userId);
        userRepository.deleteById(userId);
    }

    @Override
    public void checkIfUserAlreadyExists(UserRequest dto) {
        if (dto.getUsername().equals(userRepository.findUserByUsername(dto.getUsername()))){
            throw new ExceptionPerExistingUser("the  user already exists" + dto);
        }
    }

    @Override
    public void checkIfUserIsNotNull(Optional<UserRequest> dto) {
            if (!dto.isPresent()){
                throw  new ExceptionByNullUser("the user is null " +  dto);
            }
    }

    @Override
    public void checkIfEmailAlreadyExists(String email) {
        Optional<UserRequest> search = ofNullable(mapToDTO(userRepository.findUserByEmail(email)));
        if (search.isPresent()){
            throw new ExceptionForEmailAlreadyExists("Email already registered "+ email);
        }
    }
}
