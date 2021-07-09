package com.bookstore.Trabalho.Programacao3.dto.request;

import com.bookstore.Trabalho.Programacao3.enums.FlagType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
public class CreditCardRequest {

    private String cardName;
    private String number;
    private LocalDate expirationTime;
    private FlagType flagType;
    private String cvv;

}
