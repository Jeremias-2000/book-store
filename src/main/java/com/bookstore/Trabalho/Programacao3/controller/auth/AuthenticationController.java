package com.bookstore.Trabalho.Programacao3.controller.auth;

import com.bookstore.Trabalho.Programacao3.document.auth.Login;
import com.bookstore.Trabalho.Programacao3.dto.response.TokenResponse;
import com.bookstore.Trabalho.Programacao3.service.impl.UserServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/auth")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AuthenticationController implements AbstractAuthenticationController {


    private UserServiceImpl userService;


    @Override
    public ResponseEntity<TokenResponse> authenticate(Login login) {


      return null;
    }




}
