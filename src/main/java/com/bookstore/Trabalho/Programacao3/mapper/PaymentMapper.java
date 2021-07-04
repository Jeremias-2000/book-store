package com.bookstore.Trabalho.Programacao3.mapper;

import com.bookstore.Trabalho.Programacao3.document.payment.Payment;
import com.bookstore.Trabalho.Programacao3.dto.payment.PaymentDTO;
import com.bookstore.Trabalho.Programacao3.dto.payment.ResponsePaymentDTO;
import com.bookstore.Trabalho.Programacao3.enums.PaymentMethods;
import com.bookstore.Trabalho.Programacao3.exception.NullPaymentException;
import org.springframework.util.ObjectUtils;

public class PaymentMapper {

    public static Payment mapToModel(PaymentDTO dto){

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

    public static PaymentDTO mapToDTO(Payment payment){
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
