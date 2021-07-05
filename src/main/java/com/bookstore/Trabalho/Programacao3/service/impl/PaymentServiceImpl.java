package com.bookstore.Trabalho.Programacao3.service.impl;


import com.bookstore.Trabalho.Programacao3.document.User;
import com.bookstore.Trabalho.Programacao3.document.payment.CreditCard;
import com.bookstore.Trabalho.Programacao3.document.payment.Payment;
import com.bookstore.Trabalho.Programacao3.document.payment.PaymentSlip;
import com.bookstore.Trabalho.Programacao3.dto.UserDTO;
import com.bookstore.Trabalho.Programacao3.dto.payment.PaymentDTO;
import com.bookstore.Trabalho.Programacao3.dto.payment.RequestPaymentDTO;
import com.bookstore.Trabalho.Programacao3.dto.payment.ResponsePaymentDTO;
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
    public PaymentDTO findPaymentById(String paymentId) {
        return paymentRepository.findById(paymentId)
                .map(PaymentMapper::mapToDTO)
                .orElseThrow(() ->
                        new ExceptionForPaymentNotFound("payment does not exists : " + paymentId));
    }

    @Override
    public ResponsePaymentDTO createPayment(RequestPaymentDTO requestPaymentDTO) {
        Payment responsePayment = new Payment();
        ResponsePaymentDTO responsePaymentDTO = new ResponsePaymentDTO();

        Payment payment = conversionService.convert(requestPaymentDTO.getPayment(),Payment.class);
        UserDTO userDTO = userService.findUserById(requestPaymentDTO.getUserId());


        payment.setUserId(userDTO.getUserId());

        if (PaymentMethods.CREDIT_CARD.equals(payment.getPaymentMethod())){
            payment.setCreditCard(userDTO.getCreditCard());
            payment.setStatus(Status.SENT);

        }else if(PaymentMethods.TICKET.equals(payment.getPaymentMethod())){

            PaymentSlip paymentSlip = paymentSlipService.generatePaymentSlip();
            paymentSlipService.savePaymentSlip(PaymentSlipMapper.mapToDTO(paymentSlip));

            payment.setPaymentSlip(paymentSlip);
            payment.setStatus(Status.PROCESSING);
        }

        payment.setRegistrationDate(LocalDate.now());

        Payment pay =  paymentRepository.save(payment);
        responsePaymentDTO = ResponsePaymentMapper.mapResponse(pay);


        if (PaymentMethods.TICKET.equals(payment.getPaymentSlip().getNumber())){
            responsePaymentDTO.setTicketNumber(payment.getPaymentSlip().getNumber());
        }

        return responsePaymentDTO;
    }

    @Override
    public void deletePaymentById(String paymentId) {
        Payment payment = new Payment();
        payment = PaymentMapper.mapToModel(findPaymentById(paymentId));
        paymentRepository.delete(payment);
    }

    @Override
    public void checkIfPaymentIsNotNull(Optional<RequestPaymentDTO> dto) {

    }
}
