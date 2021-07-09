package com.bookstore.Trabalho.Programacao3.controller;

import com.bookstore.Trabalho.Programacao3.dto.request.UserRequest;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface UserController {

    @GetMapping("/all")
    @ApiOperation(value = "Retorna todos os usuários cadastros")
    ResponseEntity<?> findUsers();

    @GetMapping("/find/id/{userId}")
    @ApiOperation(value = "Retorna um usuário específico")
    ResponseEntity<?> findUserById(@PathVariable("userId") String userId);

    @PostMapping("/save")
    @ApiOperation(value = "Cadastra um novo usuario")
    ResponseEntity<?> creteUser(@RequestBody UserRequest dto);

    @PutMapping("/update/id/{userId}")
    @ApiOperation(value = "Atualiza um  usuario específico")
    ResponseEntity<?> updateUser(@PathVariable("userId") String userId,@RequestBody UserRequest dto);

    @DeleteMapping("/delete/id/{userId}/")
    @ApiOperation(value = "Deleta um  usuario específico")
    ResponseEntity<?> deleteUser(@PathVariable("userId") String userId);

}
