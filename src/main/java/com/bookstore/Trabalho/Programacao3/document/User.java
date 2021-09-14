package com.bookstore.Trabalho.Programacao3.document;


import lombok.*;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;


import java.time.LocalDate;
import java.util.Date;


@Document
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@EqualsAndHashCode
public class User  {

    @Id
    private String userId;
    private String  username;
    private LocalDate birthDay;
    private String password;
    private String email;
    private String cpf;
    private Endereco endereco;
    @CreatedDate
    private Date createdDate;
    @LastModifiedDate
    private Date lastModifiedDate;


}
