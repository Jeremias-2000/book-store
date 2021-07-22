package com.bookstore.Trabalho.Programacao3.security.permission;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ApplicationUserPermission {

   USER_READ("user:read"),
    USER_WRITE("user:write"),

    BOOK_READ("book:read"),
    BOOK_WRITE("book:write"),

    PAYMENT_READ("payment:read"),
    PAYMENT_WRITE("payment:write");

    private final String permission;




}
