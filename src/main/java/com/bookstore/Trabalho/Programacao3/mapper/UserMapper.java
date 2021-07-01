package com.bookstore.Trabalho.Programacao3.mapper;

import com.bookstore.Trabalho.Programacao3.document.User;

import com.bookstore.Trabalho.Programacao3.dto.UserDTO;

public class UserMapper {

    public User mapToModel(UserDTO dto){
        return User.builder()
                .userId(dto.getUserId())
                .userName(dto.getUserName())
                .birthDay(dto.getBirthDay())
                .password(dto.getPassword())
                .email(dto.getEmail())

                .address(dto.getAddress())
                .build();
    }


    public UserDTO mapToDTO(User user){
        return UserDTO.builder().
                userId(user.getUserId())
                .userName(user.getUserName())
                .birthDay(user.getBirthDay())
                .password(user.getPassword())
                .email(user.getEmail())

                .address(user.getAddress())
                .build();
    }
}
