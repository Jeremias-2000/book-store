package com.bookstore.Trabalho.Programacao3.mapper;

import com.bookstore.Trabalho.Programacao3.document.payment.Payment;
import com.bookstore.Trabalho.Programacao3.dto.response.PaymentResponse;

public class ResponsePaymentMapper {

    public static PaymentResponse mapResponse(Payment payment){
        return PaymentResponse
                .builder()
                .paymentId(payment.getPaymentId())
                .price(payment.getPrice())
                .paymentMethod(payment.getPaymentMethod())
                .status(payment.getStatus())
                .build();
    }
}
