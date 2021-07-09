package com.bookstore.Trabalho.Programacao3.service;

import com.bookstore.Trabalho.Programacao3.dto.request.PaymentSlipRequest;

public interface AbstractPaymentSlipService<PS> {

    PaymentSlipRequest savePaymentSlip(PaymentSlipRequest paymentSlip);
    PS generatePaymentSlip();

}
