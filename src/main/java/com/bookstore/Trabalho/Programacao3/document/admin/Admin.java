package com.bookstore.Trabalho.Programacao3.document.admin;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Size;
import java.time.LocalDate;

@Document
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Admin {

    @Id
    private String adminId;
    private String name;
    private String office;
    private String department;
    @Size(min = 4,max = 30)
    private String identificationNumber;
    @CreatedDate
    private LocalDate createDate;
}
