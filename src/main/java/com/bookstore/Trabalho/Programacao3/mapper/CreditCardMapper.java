package com.bookstore.Trabalho.Programacao3.mapper;

import com.bookstore.Trabalho.Programacao3.document.payment.CreditCard;
import com.bookstore.Trabalho.Programacao3.dto.CreditCardDTO;

public class CreditCardMapper {

    public static CreditCard mapToModel(CreditCardDTO dto){
        return CreditCard.builder()
                .cardName(dto.getCardName())
                .number(dto.getNumber())
                .expirationTime(dto.getExpirationTime())
                .flagType(dto.getFlagType())
                .cvv(dto.getCvv())
                .build();
    }
}
