package com.bookstore.Trabalho.Programacao3.dto;


import com.bookstore.Trabalho.Programacao3.document.Address;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    private Address address;
}
