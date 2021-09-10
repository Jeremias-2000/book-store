package com.bookstore.Trabalho.Programacao3.repository;

import com.bookstore.Trabalho.Programacao3.document.payment.PaymentSlip;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentSlipRepository extends MongoRepository<PaymentSlip,String> {
}
