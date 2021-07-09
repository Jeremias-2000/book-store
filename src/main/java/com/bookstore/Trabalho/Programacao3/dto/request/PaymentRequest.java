package com.bookstore.Trabalho.Programacao3.dto.request;

import com.bookstore.Trabalho.Programacao3.document.User;
import com.bookstore.Trabalho.Programacao3.document.payment.CreditCard;
import com.bookstore.Trabalho.Programacao3.document.payment.PaymentSlip;
import com.bookstore.Trabalho.Programacao3.enums.PaymentMethods;
import com.bookstore.Trabalho.Programacao3.enums.Status;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentRequest {

    private String paymentId;
    @NotEmpty
    @NotBlank
    private String userId;
    @NotEmpty
    @NotBlank
    private Double price;
    @NotEmpty
    @NotBlank
    private LocalDate registrationDate;
    @NotEmpty
    @NotBlank
    private PaymentMethods paymentMethod;

    private PaymentSlip paymentSlip;
    @NotEmpty
    @NotBlank
    private Status status;
}
