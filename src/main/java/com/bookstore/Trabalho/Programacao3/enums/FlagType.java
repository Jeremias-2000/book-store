package com.bookstore.Trabalho.Programacao3.enums;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum FlagType {

    VISA("visa"),
    HIPERCARD("hipercard"),
    MASTERCARD("mastercard"),
    NUBANK("nubank"),
    C6BANK("c6bank"),
    NEXT("next"),
    PAGBANK("pagbank"),
    ITAUCARD("itaucard");

    private final String description;
}
