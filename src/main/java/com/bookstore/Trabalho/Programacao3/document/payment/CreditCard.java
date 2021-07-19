package com.bookstore.Trabalho.Programacao3.document.payment;


import com.bookstore.Trabalho.Programacao3.enums.FlagType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;


@Data
@Builder
@AllArgsConstructor
@Document
public class CreditCard {

    private String userId;
    private String cardName;
    private String number;
    private LocalDate expirationTime;
    private FlagType flagType;
    private String cvv;

}
