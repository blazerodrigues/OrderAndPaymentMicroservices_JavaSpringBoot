package com.blaze.ps.api.service;

import com.blaze.ps.api.entity.Payment;
import com.blaze.ps.api.repository.PaymentRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.UUID;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository repository;

    private Logger log = LoggerFactory.getLogger(PaymentService.class);

    public Payment doPayment(Payment payment){
        payment.setPaymentStatus(paymentProcessing());
        payment.setTransactionId(UUID.randomUUID().toString());
        try {
            log.info("PaymentService doPayment PAYMENT: {} ",new ObjectMapper().writeValueAsString(payment));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return repository.save(payment);
    }

    //paymentProcessing helper method is for 3rd party vendor integration eg. paypal, BHIM, razorpay etc
    //for simulation, we are RANDOMLY returning payment SUCCESS or FAILURE
    public String paymentProcessing(){
        return new Random().nextBoolean()?"success":"failure";
    }

    public Payment findPaymentHistoryByOrderId(int orderId)  {
        Payment payment = repository.findByOrderId(orderId);
        try {
            log.info("PaymentService findPaymentHistoryByOrderId PAYMENT: {} ", new ObjectMapper().writeValueAsString(payment));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return payment;
    }


}
