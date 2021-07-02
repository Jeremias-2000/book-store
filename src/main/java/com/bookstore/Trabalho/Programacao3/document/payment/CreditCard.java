package com.bookstore.Trabalho.Programacao3.document.payment;


import com.bookstore.Trabalho.Programacao3.enums.FlagType;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;


@Data
public class CreditCard {

    private String cardName;
    private String number;
    private LocalDate expirationTime;
    private FlagType flagType;
    private String cvv;

}
