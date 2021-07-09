package com.bookstore.Trabalho.Programacao3.mapper;

import com.bookstore.Trabalho.Programacao3.document.payment.CreditCard;
import com.bookstore.Trabalho.Programacao3.dto.request.CreditCardRequest;

public class CreditCardMapper {

    public static CreditCard mapToModel(CreditCardRequest dto){
        return CreditCard.builder()
                .cardName(dto.getCardName())
                .number(dto.getNumber())
                .expirationTime(dto.getExpirationTime())
                .flagType(dto.getFlagType())
                .cvv(dto.getCvv())
                .build();
    }
}
