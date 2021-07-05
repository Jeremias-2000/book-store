package com.bookstore.Trabalho.Programacao3.document;


import com.bookstore.Trabalho.Programacao3.document.payment.CreditCard;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;


@Document
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    private String userId;

    @Size(max = 200)
    private String  userName;

    @NotBlank
    private Date birthDay;

    @NotBlank
    @Size(min = 8)
    private String password;

    @NotBlank
    @Email(message = "invalid email")
    private String email;

    @NotBlank
    @CPF(message = "invalid cpf")
    private String cpf;


    private CreditCard creditCard;

    @NotBlank
    private Address address;
}
