package com.bookstore.Trabalho.Programacao3.service.impl;

import com.bookstore.Trabalho.Programacao3.document.auth.Login;
import com.bookstore.Trabalho.Programacao3.dto.request.UserRequest;
import com.bookstore.Trabalho.Programacao3.exception.ExceptionForEmailNotFound;
import com.bookstore.Trabalho.Programacao3.exception.ExceptionForUnauthorizedAuthentication;
import com.bookstore.Trabalho.Programacao3.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.bookstore.Trabalho.Programacao3.mapper.UserMapper.mapToDTO;

@Service
public class AuthenticationService {

   /* @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder encoder;


    public UserRequest authenticate(Login login) {
        boolean valid = false;
        UserRequest response = mapToDTO(userRepository.findUserByEmail(login.getEmail()));
        if (response.equals(null)) {
            throw new ExceptionForEmailNotFound("Email does not existes" + login.getEmail());
        }
        valid = encoder.matches(login.getPassword(), response.getPassword());
        if (!valid) {
            throw new ExceptionForUnauthorizedAuthentication("Unauthorized authentication" + login);
        }
        return response;
    }*/
}
