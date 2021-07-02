package com.bookstore.Trabalho.Programacao3.mapper;

import com.bookstore.Trabalho.Programacao3.document.payment.Payment;
import com.bookstore.Trabalho.Programacao3.dto.payment.PaymentDTO;

public class PaymentMapper {

    public static Payment mapToModel(PaymentDTO paymentDTO){
        return Payment.builder()
                .paymentId(paymentDTO.getPaymentId())
                .price(paymentDTO.getPrice())
                .registrationDate(paymentDTO.getRegistrationDate())
                .paymentMethod(paymentDTO.getPaymentMethod())
                .paymentSlip(paymentDTO.getPaymentSlip())
                .status(paymentDTO.getStatus())
                .build();
    }

    public static PaymentDTO mapToModel(Payment payment){
        return PaymentDTO.builder()
                .paymentId(payment.getPaymentId())
                .price(payment.getPrice())
                .registrationDate(payment.getRegistrationDate())
                .paymentMethod(payment.getPaymentMethod())
                .paymentSlip(payment.getPaymentSlip())
                .status(payment.getStatus())
                .build();
    }
}
