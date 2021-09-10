package com.bookstore.Trabalho.Programacao3.document.auth;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class Login {

    private String email;
    private String password;


}
