package com.bookstore.Trabalho.Programacao3.document.payment;


import com.bookstore.Trabalho.Programacao3.enums.FlagType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Card {

    @Id
    private String cardId;
    private String cardName;
    private String number;
    private LocalDate expirationTime;
    private FlagType flagType;

}
