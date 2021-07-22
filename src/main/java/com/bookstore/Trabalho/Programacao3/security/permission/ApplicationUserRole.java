package com.bookstore.Trabalho.Programacao3.security.permission;

import com.google.common.collect.Sets;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

import static com.bookstore.Trabalho.Programacao3.security.permission.ApplicationUserPermission.*;

@AllArgsConstructor
@Getter
public enum ApplicationUserRole {

    USER(Sets.newHashSet()),
    ADMIN(Sets.newHashSet(BOOK_READ,BOOK_WRITE,USER_READ,USER_WRITE,PAYMENT_READ,PAYMENT_WRITE)),
    ADMINTRAINEE(Sets.newHashSet(BOOK_READ,USER_READ,PAYMENT_READ));


    private final Set<ApplicationUserPermission> permissions;

    public  Set<SimpleGrantedAuthority> getAuthorities(){
        Set<SimpleGrantedAuthority> permissions =  getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
        permissions.add(new SimpleGrantedAuthority("ROLE_"+this.name()));
        return permissions;
    }


}
