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

    private String  userName;

    private Date birthDay;

    private String password;

    private String email;

    private String cpf;

    private CreditCard creditCard;

    private Address address;
}
