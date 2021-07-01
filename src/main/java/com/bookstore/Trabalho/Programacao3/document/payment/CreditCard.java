package com.bookstore.Trabalho.Programacao3.document.payment;


import lombok.Data;

import java.time.LocalDate;


@Data
public class CreditCard extends Ticket{

    private String cvv;

    public CreditCard(String cvv) {
        this.cvv = cvv;
    }

    public CreditCard(String ticketId, Integer number, LocalDate dueDate, String cvv) {
        super(ticketId, number, dueDate);
        this.cvv = cvv;
    }
}
