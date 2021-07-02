package com.bookstore.Trabalho.Programacao3.document;


import com.bookstore.Trabalho.Programacao3.document.payment.CreditCard;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;
import java.util.Date;


@Document
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
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

    private CreditCard creditCard;
    @NotEmpty
    private Address address;
}
