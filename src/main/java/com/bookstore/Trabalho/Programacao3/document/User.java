package com.bookstore.Trabalho.Programacao3.document;


import com.bookstore.Trabalho.Programacao3.document.payment.CreditCard;
import com.bookstore.Trabalho.Programacao3.security.permission.ApplicationUserRole;
import lombok.*;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;

import static com.bookstore.Trabalho.Programacao3.security.permission.ApplicationUserRole.*;


@Document
@Data
@AllArgsConstructor
@Builder
@ToString
@NoArgsConstructor
@EqualsAndHashCode
public class User implements UserDetails {

    @Id
    private String userId;

    private String  userName;
    private Date birthDay;
    private String password;
    private String email;
    private String cpf;
    private Address address;
    @DBRef
    private ApplicationUserRole authorities;


    public User(String userId, String userName,
                Date birthDay, String password, String email,
                String cpf, Address address) {
        this.userId = userId;
        this.userName = userName;
        this.birthDay = birthDay;
        this.password = password;
        this.email = email;
        this.cpf = cpf;
        this.address = address;
        this.authorities = USER;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return USER.getAuthorities();
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
