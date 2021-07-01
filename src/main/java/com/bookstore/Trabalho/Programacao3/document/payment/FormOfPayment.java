package com.bookstore.Trabalho.Programacao3.document.payment;

import com.bookstore.Trabalho.Programacao3.enums.PaymentMethods;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

import static com.fasterxml.jackson.annotation.JsonInclude.*;

@Document
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
public class FormOfPayment {

    @Id
    private String paymentId;
    private Double price;
    private LocalDate registrationDate;
    private PaymentMethods paymentMethod;
    private Ticket ticket;

}
