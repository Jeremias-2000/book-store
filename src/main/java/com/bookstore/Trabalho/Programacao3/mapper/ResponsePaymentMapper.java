package com.bookstore.Trabalho.Programacao3.mapper;

import com.bookstore.Trabalho.Programacao3.document.payment.Payment;
import com.bookstore.Trabalho.Programacao3.dto.payment.ResponsePaymentDTO;

public class ResponsePaymentMapper {

    public static ResponsePaymentDTO mapResponse(Payment payment){
        return ResponsePaymentDTO
                .builder()
                .paymentId(payment.getPaymentId())
                .price(payment.getPrice())
                .paymentMethod(payment.getPaymentMethod())
                .status(payment.getStatus())
                .build();
    }
}
