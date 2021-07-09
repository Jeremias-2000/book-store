package com.bookstore.Trabalho.Programacao3.dto.request;

import com.bookstore.Trabalho.Programacao3.document.payment.PaymentSlip;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PaymentSlipRequest {

    @NotEmpty
    @NotBlank
    private String paymentId;
    @NotEmpty
    @NotBlank
    private String userId;
    @NotEmpty
    @NotBlank
    private Integer number;
    @NotEmpty
    @NotBlank
    private LocalDate dueDate;

    public PaymentSlipRequest(Integer number, LocalDate dueDate) {
        this.number = number;
        this.dueDate = dueDate;
    }
}
