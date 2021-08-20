package com.bookstore.Trabalho.Programacao3.controller;

import com.bookstore.Trabalho.Programacao3.dto.request.UserRequest;
import io.swagger.annotations.ApiOperation;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

public interface UserController {

    @GetMapping("/all")
    @ApiOperation(value = "Retorna todos os usuários cadastros")
    ResponseEntity<?> findUsers(@PageableDefault(page = 0,size = 5,sort ="username",direction = Sort.Direction.ASC) Pageable pageable);

    @GetMapping("/find/id/{userId}")

    @ApiOperation(value = "Retorna um usuário específico")
    ResponseEntity<?> findUserById(@PathVariable("userId") String userId);



    @PutMapping("/update/id/{userId}")

    @ApiOperation(value = "Atualiza um  usuario específico")
    ResponseEntity<?> updateUser(@PathVariable("userId") String userId,@RequestBody UserRequest dto);

    @DeleteMapping("/delete/id/{userId}/")
    @ApiOperation(value = "Deleta um  usuario específico")
    ResponseEntity<?> deleteUser(@PathVariable("userId") String userId);

}
