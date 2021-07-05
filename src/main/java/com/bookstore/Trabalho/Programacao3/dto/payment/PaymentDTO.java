package com.bookstore.Trabalho.Programacao3.dto.payment;

import com.bookstore.Trabalho.Programacao3.document.User;
import com.bookstore.Trabalho.Programacao3.document.payment.CreditCard;
import com.bookstore.Trabalho.Programacao3.document.payment.PaymentSlip;
import com.bookstore.Trabalho.Programacao3.enums.PaymentMethods;
import com.bookstore.Trabalho.Programacao3.enums.Status;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentDTO {

    private String paymentId;
    private String userId;
    private Double price;
    private LocalDate registrationDate;
    private PaymentMethods paymentMethod;
    private PaymentSlip paymentSlip;
    private Status status;
}
