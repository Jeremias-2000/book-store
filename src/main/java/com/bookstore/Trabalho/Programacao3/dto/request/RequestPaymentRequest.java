package com.bookstore.Trabalho.Programacao3.dto.request;



import com.bookstore.Trabalho.Programacao3.dto.request.PaymentRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RequestPaymentRequest {

    @NotEmpty
    @NotBlank
    private PaymentRequest payment;
    @NotEmpty
    @NotBlank
    private String userId;

}
