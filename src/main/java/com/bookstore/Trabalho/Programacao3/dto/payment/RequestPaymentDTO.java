package com.bookstore.Trabalho.Programacao3.dto.payment;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RequestPaymentDTO {

    private PaymentDTO payment;
    private String userId;

}