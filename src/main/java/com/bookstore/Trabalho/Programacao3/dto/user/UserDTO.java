package com.bookstore.Trabalho.Programacao3.dto.user;


import com.bookstore.Trabalho.Programacao3.document.Address;
import com.bookstore.Trabalho.Programacao3.document.User;
import com.bookstore.Trabalho.Programacao3.document.payment.CreditCard;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private String userId;

    @Size(max = 200)
    private String  userName;

    @NotBlank
    private Date birthDay;

    @NotBlank
    @Size(min = 8)
    private String password;

    @NotBlank
    @Email(message = "invalid email")
    private String email;

    @NotBlank
    @CPF(message = "invalid cpf")
    private String cpf;

    private CreditCard creditCard;

    @NotBlank
    private Address address;

    public UserDTO(User user) {
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
