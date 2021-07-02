package com.bookstore.Trabalho.Programacao3.service;

import com.bookstore.Trabalho.Programacao3.document.payment.PaymentSlip;
import com.bookstore.Trabalho.Programacao3.dto.payment.PaymentSlipDTO;

public interface AbstractPaymentSlipService<PS> {

    PaymentSlipDTO savePaymentSlip(PaymentSlipDTO paymentSlip);
    PS generatePaymentSlip();

}
