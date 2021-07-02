package com.bookstore.Trabalho.Programacao3.service.impl;

import com.bookstore.Trabalho.Programacao3.document.payment.PaymentSlip;
import com.bookstore.Trabalho.Programacao3.dto.payment.PaymentSlipDTO;
import com.bookstore.Trabalho.Programacao3.mapper.PaymentSlipMapper;
import com.bookstore.Trabalho.Programacao3.repository.PaymentSlipRepository;
import com.bookstore.Trabalho.Programacao3.service.AbstractPaymentSlipService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class PaymentSlipServiceImpl implements AbstractPaymentSlipService<PaymentSlip> {


    private PaymentSlipRepository paymentSlipRepository;

    @Override
    public PaymentSlipDTO savePaymentSlip(PaymentSlipDTO paymentSlip) {
        paymentSlipRepository.save(PaymentSlipMapper.mapToModel(paymentSlip));
        return paymentSlip;
    }

    @Override
    public PaymentSlip generatePaymentSlip() {

        Random generator = new Random();
        PaymentSlip paymentSlip = new PaymentSlip();
        paymentSlip.setNumber(generator.nextInt(101)*100);
        paymentSlip.setDueDate(LocalDate.now().plusDays(5));

        return paymentSlip;
    }
}
