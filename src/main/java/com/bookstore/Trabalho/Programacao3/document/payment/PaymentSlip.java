package com.bookstore.Trabalho.Programacao3.document.payment;

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
public class PaymentSlip {

    @Id
    private String paymentId;
    private String userId;
    private Integer number;
    private LocalDate dueDate;


}
