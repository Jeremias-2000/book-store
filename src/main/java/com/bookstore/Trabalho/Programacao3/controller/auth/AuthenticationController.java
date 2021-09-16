package com.bookstore.Trabalho.Programacao3.controller.auth;

import com.bookstore.Trabalho.Programacao3.dto.request.UserRequest;

import com.bookstore.Trabalho.Programacao3.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@RestController
@CrossOrigin(origins="*")
@RequestMapping("/api/v1/auth")
public class AuthenticationController implements AbstractAuthenticationController {


    @Autowired
    private UserServiceImpl userService;

    public AuthenticationController(UserServiceImpl userService) {
        this.userService = userService;
    }


    @Override
    public ResponseEntity<?> createUser( UserRequest dto) {
        return new ResponseEntity<>(userService.createNewUser(dto), HttpStatus.CREATED);
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
