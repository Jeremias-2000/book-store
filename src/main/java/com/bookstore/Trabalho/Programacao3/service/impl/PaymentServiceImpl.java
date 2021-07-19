package com.bookstore.Trabalho.Programacao3.service.impl;


import com.bookstore.Trabalho.Programacao3.document.payment.Payment;
import com.bookstore.Trabalho.Programacao3.document.payment.PaymentSlip;
import com.bookstore.Trabalho.Programacao3.dto.request.UserRequest;
import com.bookstore.Trabalho.Programacao3.dto.request.PaymentRequest;
import com.bookstore.Trabalho.Programacao3.dto.request.RequestPaymentRequest;
import com.bookstore.Trabalho.Programacao3.dto.response.PaymentResponse;
import com.bookstore.Trabalho.Programacao3.enums.PaymentMethods;
import com.bookstore.Trabalho.Programacao3.enums.Status;
import com.bookstore.Trabalho.Programacao3.exception.ExceptionForPaymentNotFound;
import com.bookstore.Trabalho.Programacao3.mapper.PaymentMapper;
import com.bookstore.Trabalho.Programacao3.mapper.PaymentSlipMapper;
import com.bookstore.Trabalho.Programacao3.mapper.ResponsePaymentMapper;
import com.bookstore.Trabalho.Programacao3.repository.PaymentRepository;

import com.bookstore.Trabalho.Programacao3.service.AbstractPaymentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PaymentServiceImpl implements AbstractPaymentService{

    private UserServiceImpl userService;
    private ConversionService conversionService;
    private PaymentRepository paymentRepository;
    private PaymentSlipServiceImpl paymentSlipService;




    @Override
    public PaymentRequest findPaymentById(String paymentId) {
        return paymentRepository.findById(paymentId)
                .map(PaymentMapper::mapToDTO)
                .orElseThrow(() ->
                        new ExceptionForPaymentNotFound("payment does not exists : " + paymentId));
    }

  /*  @Override
    public PaymentResponse createPayment(RequestPaymentRequest requestPaymentRequest) {
        Payment responsePayment = new Payment();
        PaymentResponse paymentResponse = new PaymentResponse();

        Payment payment = conversionService.convert(requestPaymentRequest.getPayment(),Payment.class);
        UserRequest userRequest = userService.findUserById(requestPaymentRequest.getUserId());


        payment.setUserId(userRequest.getUserId());

        if (PaymentMethods.CREDIT_CARD.equals(payment.getPaymentMethod())){
            payment.setCreditCard(userRequest.getCreditCard());
            payment.setStatus(Status.SENT);

        }else if(PaymentMethods.TICKET.equals(payment.getPaymentMethod())){

            PaymentSlip paymentSlip = paymentSlipService.generatePaymentSlip();
            paymentSlipService.savePaymentSlip(PaymentSlipMapper.mapToDTO(paymentSlip));

            payment.setPaymentSlip(paymentSlip);
            payment.setStatus(Status.PROCESSING);
        }

        payment.setRegistrationDate(LocalDate.now());

        Payment pay =  paymentRepository.save(payment);
        paymentResponse = ResponsePaymentMapper.mapResponse(pay);


        if (PaymentMethods.TICKET.equals(payment.getPaymentSlip().getNumber())){
            paymentResponse.setTicketNumber(payment.getPaymentSlip().getNumber());
        }

        return paymentResponse;
    }*/

    @Override
    public void deletePaymentById(String paymentId) {
        Payment payment = new Payment();
        payment = PaymentMapper.mapToModel(findPaymentById(paymentId));
        paymentRepository.delete(payment);
    }

    @Override
    public void checkIfPaymentIsNotNull(Optional<RequestPaymentRequest> dto) {

    }
}
