package com.bookstore.Trabalho.Programacao3.mapper;

import com.bookstore.Trabalho.Programacao3.document.payment.Payment;
import com.bookstore.Trabalho.Programacao3.dto.request.PaymentRequest;
import com.bookstore.Trabalho.Programacao3.exception.NullPaymentException;

public class PaymentMapper {

    public static Payment mapToModel(PaymentRequest dto){

            if (dto.equals(null)){
                throw  new NullPaymentException("payment information is null" + dto);
            }
            return Payment.builder()
                    .paymentId(dto.getPaymentId())
                    .price(dto.getPrice())
                    .registrationDate(dto.getRegistrationDate())
                    .paymentMethod(dto.getPaymentMethod())
                    .paymentSlip(dto.getPaymentSlip())
                    .status(dto.getStatus())
                    .build();
    }

    public static PaymentRequest mapToDTO(Payment payment){
        return PaymentRequest.builder()
                .paymentId(payment.getPaymentId())
                .price(payment.getPrice())
                .registrationDate(payment.getRegistrationDate())
                .paymentMethod(payment.getPaymentMethod())
                .paymentSlip(payment.getPaymentSlip())
                .status(payment.getStatus())
                .build();
    }
}
