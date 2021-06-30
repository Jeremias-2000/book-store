package com.bookstore.Trabalho.Programacao3.document;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    private String customerId;

    private String  userName;
    private String password;
    private String email;
    private String creditCard;
    private Address address;
}
