package com.bookstore.Trabalho.Programacao3.controller.impl;

import com.bookstore.Trabalho.Programacao3.controller.PaymentController;
import com.bookstore.Trabalho.Programacao3.dto.payment.RequestPaymentDTO;
import com.bookstore.Trabalho.Programacao3.service.impl.PaymentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/payments")
public class PaymentControllerImpl implements PaymentController {

    @Autowired
    private PaymentServiceImpl paymentService;

    @Override
    public ResponseEntity<?> findPayment(String paymentId) {
        return ResponseEntity.ok(paymentService.findPaymentById(paymentId));
    }

    @Override
    public ResponseEntity<?> makePayment(RequestPaymentDTO requestPaymentDTO) {
        return new ResponseEntity<>(paymentService.createPayment(requestPaymentDTO), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> deletePayment(String paymentId) {
        paymentService.deletePaymentById(paymentId);
        return ResponseEntity.ok().build();
    }
}
