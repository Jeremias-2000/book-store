package com.bookstore.Trabalho.Programacao3.service.impl;


import com.bookstore.Trabalho.Programacao3.document.Endereco;
import com.bookstore.Trabalho.Programacao3.document.User;
import com.bookstore.Trabalho.Programacao3.dto.request.UserRequest;
import com.bookstore.Trabalho.Programacao3.exception.*;
import com.bookstore.Trabalho.Programacao3.mapper.UserMapper;
import com.bookstore.Trabalho.Programacao3.repository.EnderecoRepository;
import com.bookstore.Trabalho.Programacao3.repository.UserRepository;
import com.bookstore.Trabalho.Programacao3.service.AbstractUserService;

import com.bookstore.Trabalho.Programacao3.service.cep.ViaApiService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import javax.swing.text.html.Option;
import java.util.Optional;

import static com.bookstore.Trabalho.Programacao3.mapper.UserMapper.*;
import static java.util.Optional.*;


@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserServiceImpl implements AbstractUserService<UserRequest> {


    private UserRepository userRepository;
    private EnderecoRepository enderecoRepository;
    private ViaApiService viaCepService;


    @Override
    public Page<UserRequest> findUsers(Pageable pageable) {
       return userRepository.findAll(pageable).map(UserMapper::mapToUserDTO);

    }



    @Override
    public UserRequest findUserById(String userId) {
        return userRepository.findById(userId)
                .map(UserMapper::mapToUserDTO)
                .orElseThrow(() ->
                        new UserNotFoundException("id does not exists  ==> " + userId + "\n"));
    }



    @Override
    public UserRequest createNewUser(UserRequest user) {

        checkIfUserAlreadyExists(user);
        checkIfEmailAlreadyExists(user.getEmail());

        String cep = user.getEndereco().getCep();
        //verifica se existe endereco
        Endereco endereco =  enderecoRepository.findById(cep).orElseGet(() -> {
            Endereco novoEndereco = viaCepService.consultarCep(cep);
            enderecoRepository.save(novoEndereco);
            return novoEndereco;
        });


        user.setEndereco(endereco);
        checkIfUserIsNull(ofNullable(user));
        userRepository.save(UserMapper.mapToModel(user));
        return user;
    }

    @Override
    public UserRequest updateUserById(String userId, UserRequest dto) {
        userRepository.findById(userId)
                .map(user -> mapToModel(dto));

         return dto;
    }

    @Override
    public void deleteUserById(String userId) {
        findUserById(userId);
        userRepository.deleteById(userId);
    }

    @Override
    public void checkIfUserAlreadyExists(UserRequest dto) {
        boolean search = userRepository.findUserByUsername(dto.getUsername()).isPresent();
        if (search){
            throw new ExceptionPerExistingUser("the  user already exists" + dto);
        }
    }

    @Override
    public void checkIfUserIsNull(Optional<UserRequest> dto) {

        if (!dto.isPresent()){
            throw  new NullPointerException("the user must not be null "+dto);
        }
    }

    @Override
    public void checkIfEmailAlreadyExists(String email) {

        Optional<User> search =  userRepository.findUserByEmail(email);
        if (search.isPresent()){
            throw new ExceptionForEmailAlreadyExists("Email already registered "+ email);
        }
    }
}
