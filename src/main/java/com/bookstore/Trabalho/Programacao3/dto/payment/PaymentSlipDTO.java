package com.bookstore.Trabalho.Programacao3.dto.payment;

import com.bookstore.Trabalho.Programacao3.document.payment.PaymentSlip;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PaymentSlipDTO {

    private String paymentId;
    private String userId;
    private Integer number;
    private LocalDate dueDate;

    public PaymentSlipDTO(Integer number,LocalDate dueDate) {
        this.number = number;
        this.dueDate = dueDate;
    }
}
