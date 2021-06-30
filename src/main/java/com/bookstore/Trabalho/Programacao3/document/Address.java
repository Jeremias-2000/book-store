package com.bookstore.Trabalho.Programacao3.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {


    private String cep;
    private String state;
    private String city;
    private String district;
    private String road;
    private int  houseNumber;

}
