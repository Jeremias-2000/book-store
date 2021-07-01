package com.bookstore.Trabalho.Programacao3.service.impl;

import com.bookstore.Trabalho.Programacao3.dto.BookDTO;
import com.bookstore.Trabalho.Programacao3.repository.UserRepository;
import com.bookstore.Trabalho.Programacao3.service.AbstractUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements AbstractUserService<BookDTO> {


    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<BookDTO> findUsers() {
        return null;
    }

    @Override
    public BookDTO findUserById(String userId) {
        return null;
    }

    @Override
    public BookDTO createNewUser(BookDTO user) {
        return null;
    }

    @Override
    public BookDTO updateUserById(String userId) {
        return null;
    }

    @Override
    public void deleteUserById(String userId) {

    }
}
