package com.bookstore.Trabalho.Programacao3.controller.impl;

import com.bookstore.Trabalho.Programacao3.controller.UserController;
import com.bookstore.Trabalho.Programacao3.dto.request.UserRequest;
import com.bookstore.Trabalho.Programacao3.service.impl.UserServiceImpl;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/user")
@CrossOrigin
@Api(value = "Users")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserControllerImpl implements UserController {


    private UserServiceImpl userService;


    @Override
    @Cacheable("Users")
    public ResponseEntity<?> findUsers(Pageable pageable) {
        return ResponseEntity.ok(userService.findUsers(pageable));
    }

    @Override
    @Cacheable("user id")
    public ResponseEntity<?> findUserById(String userId) {
        return ResponseEntity.ok(userService.findUserById(userId));
    }

    @Override
    public ResponseEntity<?> createUser( UserRequest dto) {
        return new ResponseEntity<>(userService.createNewUser(dto), HttpStatus.CREATED);
    }

    @Override
    @CacheEvict("user id")
    public ResponseEntity<?> updateUser(String userId, UserRequest dto) {
        return ResponseEntity.ok(userService.updateUserById(userId, dto));
    }

    @Override
    //@Caching(evict = {@CacheEvict("Users"),@CacheEvict("User id")})
    @CacheEvict(value = {"Users","user id"},allEntries = true)
    public ResponseEntity<?> deleteUser(String userId) {
        userService.deleteUserById(userId);
        return ResponseEntity.ok().build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String,String> handleValidationException(MethodArgumentNotValidException exception){
        Map<String,String> errors = new HashMap<>();
        exception.getBindingResult().getAllErrors().forEach(
                (error) -> {

                    String   fieldName = ((FieldError) error).getField();
                    String errorMessage = error.getDefaultMessage();
                    errors.put(fieldName,errorMessage);

                });
        return errors;

    }
}
