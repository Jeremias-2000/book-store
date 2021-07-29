package com.bookstore.Trabalho.Programacao3.mapper;

import com.bookstore.Trabalho.Programacao3.document.User;

import com.bookstore.Trabalho.Programacao3.dto.request.UserRequest;
import org.springframework.data.domain.Page;


public class UserMapper {




    public static User mapToModel(UserRequest dto){
        return User.builder()
                .userId(dto.getUserId())
                .username(dto.getUsername())
                .birthDay(dto.getBirthDay())
                .password(dto.getPassword())
                .email(dto.getEmail())
                .cpf(dto.getCpf())
                .address(dto.getAddress())
                .build();
    }


    public static UserRequest mapToDTO(User user){
        return  UserRequest.builder()
                .userId(user.getUserId())
                .username(user.getUsername())
                .birthDay(user.getBirthDay())
                .password(user.getPassword())
                .email(user.getEmail())
                .cpf(user.getCpf())
                .address(user.getAddress())
                .build();
    }



}
