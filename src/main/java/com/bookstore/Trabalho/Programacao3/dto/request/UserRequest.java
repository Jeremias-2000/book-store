package com.bookstore.Trabalho.Programacao3.dto.request;


import com.bookstore.Trabalho.Programacao3.document.Address;
import com.bookstore.Trabalho.Programacao3.document.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;


import javax.validation.constraints.*;
import java.time.LocalDate;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class UserRequest  {


    private String userId;

    @NotBlank(message = "Nome do usuário não informado")
    @Pattern(regexp = "^[A-Z]+(.)*",message = "Nome deve iniciar com letra maiúscula")
    @Size(max = 200)
    private String  username;


    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", locale = "pt-BR", timezone = "Brazil/East")
    private LocalDate birthDay;

    @NotBlank(message = "Email não informado")
    @Size(min = 8)
    private String password;

    @NotBlank(message = "Email não informado")
    @Email(message = "invalid email")
    private String email;

    @NotBlank(message = "Campo inválido")
    @CPF(message = "invalid cpf")
    private String cpf;

    @NotNull
    private Address address;

















}
