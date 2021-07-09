package com.bookstore.Trabalho.Programacao3.dto.request;


import com.bookstore.Trabalho.Programacao3.document.Address;
import com.bookstore.Trabalho.Programacao3.document.User;
import com.bookstore.Trabalho.Programacao3.document.payment.CreditCard;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.*;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {

    private String userId;

    @NotEmpty
    @NotNull
    @Size(max = 200)
    private String  userName;

    @NotBlank
    private Date birthDay;

    @NotBlank
    @NotEmpty
    @Size(min = 8)
    private String password;

    @NotBlank
    @NotEmpty
    @Email(message = "invalid email")
    private String email;

    @NotBlank
    @NotEmpty
    @CPF(message = "invalid cpf")
    private String cpf;

    private CreditCard creditCard;

    @NotBlank
    private Address address;

    public UserRequest(User user) {
        this.userId = user.getUserId();
        this.userName = user.getUserName();
        this.birthDay = user.getBirthDay();
        this.password = user.getPassword();
        this.email = user.getEmail();
        this.cpf = user.getCpf();
        this.address = user.getAddress();
        this.creditCard =user.getCreditCard();
    }
}
