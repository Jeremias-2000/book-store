package com.bookstore.Trabalho.Programacao3.dto.response;

import com.bookstore.Trabalho.Programacao3.document.payment.PaymentSlip;
import com.bookstore.Trabalho.Programacao3.enums.PaymentMethods;
import com.bookstore.Trabalho.Programacao3.enums.Status;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

import static com.fasterxml.jackson.annotation.JsonInclude.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class PaymentResponse {


    private String paymentId;
    @NotEmpty
    @NotBlank
    private Double price;
    @NotEmpty
    @NotBlank
    private PaymentMethods paymentMethod;

    @JsonInclude(Include.NON_NULL)
    private Integer ticketNumber;
    @NotEmpty
    @NotBlank
    private Status status;


}
