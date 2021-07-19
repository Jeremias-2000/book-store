package com.bookstore.Trabalho.Programacao3.document;


import com.bookstore.Trabalho.Programacao3.document.payment.CreditCard;
import lombok.*;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;


@Document
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class User {

    @Id
    private String userId;

    private String  userName;
    private Date birthDay;
    private String password;
    private String email;
    private String cpf;
    private Address address;





}
