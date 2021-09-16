package com.bookstore.Trabalho.Programacao3.mapper;

import com.bookstore.Trabalho.Programacao3.document.User;

import com.bookstore.Trabalho.Programacao3.dto.request.UserRequest;

import java.util.Optional;


public class UserMapper {




    public static User mapToModel(UserRequest dto){
        return User.builder()
                .userId(dto.getUserId())
                .username(dto.getUsername())
                .birthDay(dto.getBirthDay())
                .password(dto.getPassword())
                .email(dto.getEmail())
                .cpf(dto.getCpf())
                .endereco(dto.getEndereco())
                .createdDate(dto.getCreatedDate())
                .lastModifiedDate(dto.getLastModifiedDate())
                .build();
    }


    public static UserRequest mapToUserDTO(User user){
        return   UserRequest.builder()
                .userId(user.getUserId())
                .username(user.getUsername())
                .birthDay(user.getBirthDay())
                .password(user.getPassword())
                .email(user.getEmail())
                .cpf(user.getCpf())
                .endereco(user.getEndereco())
                .createdDate(user.getCreatedDate())
                .lastModifiedDate(user.getLastModifiedDate())
                .build();
    }

    public static Optional<UserRequest> mapToDTO(User user){
        return Optional.of(UserRequest.builder()
                .userId(user.getUserId())
                .username(user.getUsername())
                .birthDay(user.getBirthDay())
                .password(user.getPassword())
                .email(user.getEmail())
                .cpf(user.getCpf())
                .endereco(user.getEndereco())
                .createdDate(user.getCreatedDate())
                .lastModifiedDate(user.getLastModifiedDate()).build());
    }



}
