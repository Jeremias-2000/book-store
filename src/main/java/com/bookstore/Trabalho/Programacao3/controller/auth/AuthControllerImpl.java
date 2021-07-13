package com.bookstore.Trabalho.Programacao3.controller.auth;


import com.bookstore.Trabalho.Programacao3.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api/v1/management/")
public class AuthControllerImpl implements AuthController{

    @Autowired
    private UserServiceImpl userService;

    @Override
    public ResponseEntity<?> login(String email, String password) {
        return null;
    }
}
