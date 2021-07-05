package com.bookstore.Trabalho.Programacao3.controller.impl;

import com.bookstore.Trabalho.Programacao3.controller.UserController;
import com.bookstore.Trabalho.Programacao3.dto.UserDTO;
import com.bookstore.Trabalho.Programacao3.service.impl.UserServiceImpl;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
@CrossOrigin(origins = "*")
@Api(value = "Users")
public class UserControllerImpl implements UserController {

    @Autowired
    private UserServiceImpl userService;

    @Override
    public ResponseEntity<?> findUsers() {
        return ResponseEntity.ok(userService.findUsers());
    }

    @Override
    public ResponseEntity<?> findUserById(String userId) {
        return ResponseEntity.ok(userService.findUserById(userId));
    }

    @Override
    public ResponseEntity<?> creteUser(UserDTO dto) {
        return new ResponseEntity<>(userService.createNewUser(dto), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> updateUser(String userId, UserDTO dto) {
        return ResponseEntity.ok(userService.updateUserById(userId, dto));
    }

    @Override
    public ResponseEntity<?> deleteUser(String userId) {
        return ResponseEntity.ok().build();
    }
}
