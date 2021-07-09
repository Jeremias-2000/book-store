package com.bookstore.Trabalho.Programacao3.mapper;

import com.bookstore.Trabalho.Programacao3.document.payment.PaymentSlip;
import com.bookstore.Trabalho.Programacao3.dto.request.PaymentSlipRequest;

public class PaymentSlipMapper {

    public static PaymentSlip mapToModel(PaymentSlipRequest paymentSlipRequest){
        return PaymentSlip.builder()
                .paymentId(paymentSlipRequest.getPaymentId())
                .userId(paymentSlipRequest.getUserId())
                .number(paymentSlipRequest.getNumber())
                .dueDate(paymentSlipRequest.getDueDate())
                .build();
    }


    public static PaymentSlipRequest mapToDTO(PaymentSlip paymentSlip){
        return PaymentSlipRequest.builder()
                .paymentId(paymentSlip.getPaymentId())
                .userId(paymentSlip.getUserId())
                .number(paymentSlip.getNumber())
                .dueDate(paymentSlip.getDueDate())
                .build();
    }
}
