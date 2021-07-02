package com.bookstore.Trabalho.Programacao3.mapper;

import com.bookstore.Trabalho.Programacao3.document.payment.PaymentSlip;
import com.bookstore.Trabalho.Programacao3.dto.payment.PaymentSlipDTO;

public class PaymentSlipMapper {

    public static PaymentSlip mapToModel(PaymentSlipDTO paymentSlipDTO){
        return PaymentSlip.builder()
                .paymentId(paymentSlipDTO.getPaymentId())
                .userId(paymentSlipDTO.getUserId())
                .number(paymentSlipDTO.getNumber())
                .dueDate(paymentSlipDTO.getDueDate())
                .build();
    }


    public static PaymentSlipDTO mapToDTO(PaymentSlip paymentSlip){
        return PaymentSlipDTO.builder()
                .paymentId(paymentSlip.getPaymentId())
                .userId(paymentSlip.getUserId())
                .number(paymentSlip.getNumber())
                .dueDate(paymentSlip.getDueDate())
                .build();
    }
}
