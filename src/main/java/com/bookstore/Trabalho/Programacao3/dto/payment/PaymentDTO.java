package com.bookstore.Trabalho.Programacao3.dto.payment;

import com.bookstore.Trabalho.Programacao3.document.payment.PaymentSlip;
import com.bookstore.Trabalho.Programacao3.enums.PaymentMethods;
import com.bookstore.Trabalho.Programacao3.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor

public class PaymentDTO {

    @NotNull
    private String paymentId;
    @NotEmpty
    private Double price;
    @NotEmpty
    private LocalDate registrationDate;
    @NotEmpty
    private PaymentMethods paymentMethod;
    @NotNull
    private PaymentSlip paymentSlip;
    @NotNull
    private Status status;
}
