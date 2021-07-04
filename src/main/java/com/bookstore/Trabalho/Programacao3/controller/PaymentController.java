package com.bookstore.Trabalho.Programacao3.controller;

import com.bookstore.Trabalho.Programacao3.dto.payment.RequestPaymentDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface PaymentController {

    @GetMapping("/fin//id/{paymentId}")
    ResponseEntity<?> findPayment(@PathVariable("paymentId") String paymentId);

    @PostMapping("/save")
    ResponseEntity<?> makePayment(@RequestBody RequestPaymentDTO requestPaymentDTO);

    @DeleteMapping("/delete/id/{paymentId}")
    ResponseEntity<?> deletePayment(@PathVariable("paymentId") String paymentId);
}
