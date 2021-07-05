package com.bookstore.Trabalho.Programacao3.service.impl;


import com.bookstore.Trabalho.Programacao3.document.User;
import com.bookstore.Trabalho.Programacao3.dto.user.UserDTO;
import com.bookstore.Trabalho.Programacao3.exception.ExceptionByNullUser;
import com.bookstore.Trabalho.Programacao3.exception.ExceptionPerExistingUser;
import com.bookstore.Trabalho.Programacao3.exception.UserNotFoundException;
import com.bookstore.Trabalho.Programacao3.mapper.UserMapper;
import com.bookstore.Trabalho.Programacao3.repository.UserRepository;
import com.bookstore.Trabalho.Programacao3.service.AbstractUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Optional.*;


@Service

public class UserServiceImpl implements AbstractUserService<UserDTO> {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserDTO> findUsers() {
        return userRepository.findAll()
                .stream().map(UserMapper::mapToDTO)
                .collect(Collectors.toList());
    }


    public List<UserDTO> convertToListUserDTO(List<User> users) {
        return users.stream().map(UserDTO::new).collect(Collectors.toList());
    }

    @Override
    public UserDTO findUserById(String userId) {
        return userRepository.findById(userId)
                .map(UserMapper::mapToDTO)
                .orElseThrow(() ->
                        new UserNotFoundException("id does not exists" + userId));
    }

    @Override
    public UserDTO createNewUser(UserDTO user) {
        checkIfUserIsNotNull(ofNullable(user));
        checkIfUserAlreadyExists(user);
        userRepository.save(UserMapper.mapToModel(user));
        return user ;
    }

    @Override
    public UserDTO updateUserById(String userId, UserDTO dto) {
        userRepository.findById(userId)
                .map(user -> UserMapper.mapToModel(dto));

         return dto;
    }

    @Override
    public void deleteUserById(String userId) {
        UserDTO dto = findUserById(userId);
        userRepository.delete(UserMapper.mapToModel(dto));
    }

    @Override
    public void checkIfUserAlreadyExists(UserDTO dto) {
        if (dto.getUserName().equals(userRepository.findUserByUserName(dto.getUserName()))){
            throw new ExceptionPerExistingUser("the  user already exists" + dto);
        }
    }

    @Override
    public void checkIfUserIsNotNull(Optional<UserDTO> dto) {
            if (!dto.isPresent()){
                throw  new ExceptionByNullUser("the user is null " +  dto);
            }
    }
}
