package com.bookstore.Trabalho.Programacao3.controller.impl;

import com.bookstore.Trabalho.Programacao3.controller.PaymentController;
import com.bookstore.Trabalho.Programacao3.dto.request.RequestPaymentRequest;
import com.bookstore.Trabalho.Programacao3.service.impl.PaymentServiceImpl;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/payments")
@CrossOrigin(origins = "*")
@Api(value = "Payments")
public class PaymentControllerImpl implements PaymentController {

    @Autowired
    private PaymentServiceImpl paymentService;

    @Override
    public ResponseEntity<?> findPayment(String paymentId) {
        return ResponseEntity.ok(paymentService.findPaymentById(paymentId));
    }

    @Override
    public ResponseEntity<?> makePayment(RequestPaymentRequest requestPaymentRequest) {
        return new ResponseEntity<>(paymentService.createPayment(requestPaymentRequest), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> deletePayment(String paymentId) {
        paymentService.deletePaymentById(paymentId);
        return ResponseEntity.ok().build();
    }
}
