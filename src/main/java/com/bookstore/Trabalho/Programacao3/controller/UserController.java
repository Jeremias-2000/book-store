package com.bookstore.Trabalho.Programacao3.controller;

import com.bookstore.Trabalho.Programacao3.dto.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface UserController {

    @GetMapping("/all")
    ResponseEntity<?> findUsers();

    @GetMapping("/find/id/{userId}")
    ResponseEntity<?> findUserById(@PathVariable("userId") String userId);

    @PostMapping("/save")
    ResponseEntity<?> creteUser(@RequestBody UserDTO dto);

    @PutMapping("/update/id/{userId}")
    ResponseEntity<?> updateUser(@PathVariable("userId") String userId,@RequestBody UserDTO dto);

    @DeleteMapping("/delete/id/{userId}/")
    ResponseEntity<?> deleteUser(@PathVariable("userId") String userId);

}
