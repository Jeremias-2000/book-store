package com.bookstore.Trabalho.Programacao3.dto;


import com.bookstore.Trabalho.Programacao3.document.Address;
import com.bookstore.Trabalho.Programacao3.document.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private String userId;

    private String  userName;

    private Date birthDay;

    private String password;

    private String email;

    private String cpf;

    private Address address;

    public UserDTO(User user) {
        this.userId = user.getUserId();
        this.userName = user.getUserName();
        this.birthDay = user.getBirthDay();
        this.password = user.getPassword();
        this.email = user.getEmail();
        this.cpf = user.getCpf();
        this.address = user.getAddress();
    }
}
