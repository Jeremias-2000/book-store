package com.bookstore.Trabalho.Programacao3.dto;


import com.bookstore.Trabalho.Programacao3.document.Address;
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
    @NotEmpty
    private String  userName;
    @NotEmpty
    private Date birthDay;
    @NotEmpty
    private String password;
    @NotEmpty
    private String email;
    @NotEmpty
    private String cpf;
    @NotEmpty
    private Address address;
}
