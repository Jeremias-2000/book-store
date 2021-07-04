package com.bookstore.Trabalho.Programacao3.service;

import com.bookstore.Trabalho.Programacao3.dto.UserDTO;
import com.bookstore.Trabalho.Programacao3.dto.payment.PaymentDTO;
import com.bookstore.Trabalho.Programacao3.dto.payment.RequestPaymentDTO;
import com.bookstore.Trabalho.Programacao3.dto.payment.ResponsePaymentDTO;


import java.util.Optional;

public interface AbstractPaymentService{


    PaymentDTO findPaymentById(String paymentId);
    ResponsePaymentDTO createPayment(RequestPaymentDTO paymentDTO);
    void deletePaymentById(String userId);
    void checkIfPaymentIsNotNull(Optional<RequestPaymentDTO> dto);
}
