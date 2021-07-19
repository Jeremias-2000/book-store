package com.bookstore.Trabalho.Programacao3.controller;

import com.bookstore.Trabalho.Programacao3.dto.request.RequestPaymentRequest;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface PaymentController {

    @GetMapping("/fin//id/{paymentId}")
    @ApiOperation(value = "Retorna um pagamento ")
    ResponseEntity<?> findPayment(@PathVariable("paymentId") String paymentId);

    /*@PostMapping("/save")
    @ApiOperation(value = "Realiza um pagamento ")
    ResponseEntity<?> makePayment(@RequestBody RequestPaymentRequest requestPaymentRequest);*/

    @DeleteMapping("/delete/id/{paymentId}")
    @ApiOperation(value = "Deleta um pagamento ")
    ResponseEntity<?> deletePayment(@PathVariable("paymentId") String paymentId);
}
