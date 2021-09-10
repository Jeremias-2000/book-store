package com.bookstore.Trabalho.Programacao3.security;

import com.google.common.collect.Sets;
import lombok.AllArgsConstructor;
import lombok.Getter;


import java.util.Set;

@AllArgsConstructor
@Getter
public enum ApplicationUserRole {

    USER(Sets.newHashSet()),
    ADMIN(Sets.newHashSet(ApplicationUserPermission.BOOK_READ, ApplicationUserPermission.BOOK_WRITE, ApplicationUserPermission.USER_READ, ApplicationUserPermission.USER_WRITE, ApplicationUserPermission.PAYMENT_READ, ApplicationUserPermission.PAYMENT_WRITE)),
    ADMINTRAINEE(Sets.newHashSet(ApplicationUserPermission.BOOK_READ, ApplicationUserPermission.USER_READ, ApplicationUserPermission.PAYMENT_READ));


    private final Set<ApplicationUserPermission> permissions;




}
