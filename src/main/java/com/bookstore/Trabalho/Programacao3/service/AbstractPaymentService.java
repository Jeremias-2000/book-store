package com.bookstore.Trabalho.Programacao3.service;

import com.bookstore.Trabalho.Programacao3.dto.request.PaymentRequest;
import com.bookstore.Trabalho.Programacao3.dto.request.RequestPaymentRequest;
import com.bookstore.Trabalho.Programacao3.dto.response.PaymentResponse;


import java.util.Optional;

public interface AbstractPaymentService{


    PaymentRequest findPaymentById(String paymentId);
   // PaymentResponse createPayment(RequestPaymentRequest paymentDTO);
    void deletePaymentById(String userId);
    void checkIfPaymentIsNotNull(Optional<RequestPaymentRequest> dto);
}
