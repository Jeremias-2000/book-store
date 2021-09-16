package com.bookstore.Trabalho.Programacao3.controller.auth;


import com.bookstore.Trabalho.Programacao3.document.auth.Login;
import com.bookstore.Trabalho.Programacao3.dto.request.UserRequest;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

public interface AbstractAuthenticationController {




    @PostMapping("/signup")
    @ApiOperation(value = "Cadastra um novo usuario")
    ResponseEntity<?> createUser(@RequestBody @Valid UserRequest dto);


}
