package com.bookstore.Trabalho.Programacao3.controller;

import com.bookstore.Trabalho.Programacao3.dto.request.UserRequest;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface UserController {

    @GetMapping("/all")
   // @PreAuthorize("hasAnyRole('ROLE.ADMIN','ROLE_ADMINTRAINEE')")
    @ApiOperation(value = "Retorna todos os usuários cadastros")
    ResponseEntity<?> findUsers();

    @GetMapping("/find/id/{userId}")
    //@PreAuthorize("hasAuthority('user:read')")
    @ApiOperation(value = "Retorna um usuário específico")
    ResponseEntity<?> findUserById(@PathVariable("userId") String userId);

    @PostMapping("/save")
    //   @PreAuthorize("hasAuthority('user:write')")
    @ApiOperation(value = "Cadastra um novo usuario")
    ResponseEntity<?> creteUser(@RequestBody UserRequest dto);

    @PutMapping("/update/id/{userId}")
    //@PreAuthorize("hasAuthority('user:write')")
    @ApiOperation(value = "Atualiza um  usuario específico")
    ResponseEntity<?> updateUser(@PathVariable("userId") String userId,@RequestBody UserRequest dto);

    @DeleteMapping("/delete/id/{userId}/")
    //@PreAuthorize("hasAuthority('user:write')")
    @ApiOperation(value = "Deleta um  usuario específico")
    ResponseEntity<?> deleteUser(@PathVariable("userId") String userId);

}
