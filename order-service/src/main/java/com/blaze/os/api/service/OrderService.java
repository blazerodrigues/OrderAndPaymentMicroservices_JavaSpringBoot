package com.blaze.os.api.service;

import com.blaze.os.api.common.Payment;
import com.blaze.os.api.common.TransactionRequest;
import com.blaze.os.api.common.TransactionResponse;
import com.blaze.os.api.entity.Order;
import com.blaze.os.api.repository.OrderRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service //Service annotation
@RefreshScope
public class OrderService {

    @Autowired //Autowired annotation
    private OrderRepository repository;

    //To do a REST call from one service to another service, we need the REST TEMPLATE in the MAIN APPLICATION CLASS
    @Autowired
    @Lazy
    private RestTemplate restTemplate;

    @Value("${microservice.payment-service.endpoints.endpoint.uri}")
    private String ENDPOINT_URL;

    //Logging. We will implement ELK stack for centralized logging (ElasticSearch(storage) Logstash(processing) Kibana(visualization))
    private Logger log = LoggerFactory.getLogger(OrderService.class);

    public TransactionResponse saveOrder(TransactionRequest request) {

        //Logging OrderService request
        try {
            log.info("OrderService saveOrder REQUEST: {} ", new ObjectMapper().writeValueAsString(request)); //ObjectMapper().writeValueAsString(request) converts JSON into STRING
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        //Getting Order details from the request
        Order order = request.getOrder();

        //Getting Payment details from the request
        Payment payment = request.getPayment();

        //Saving the Order to DB
        Order savedOrder = repository.save(order);

        payment.setOrderId(savedOrder.getId());
        payment.setAmount(savedOrder.getPrice());
        //REST call to Payment API (using REST TEMPLATE)
        Payment paymentResponse = restTemplate.postForObject(ENDPOINT_URL,payment,Payment.class); //passing the URL, OBJECT, Response TYPE
        //Logging paymentResponse
        try {
            log.info("OrderService saveOrder (PaymentService call) RESPONSE: {} ", new ObjectMapper().writeValueAsString(paymentResponse));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        String message = "";
        if(paymentResponse.getPaymentStatus().equalsIgnoreCase("success")){
            message = "Payment successful. Order placed.";
        }else {
            message = "Payment failed. Order is in the cart, please try again.";
        }

        TransactionResponse transactionResponse = new TransactionResponse();
        transactionResponse.setOrder(savedOrder);
        transactionResponse.setAmount(paymentResponse.getAmount());
        transactionResponse.setTransactionId(paymentResponse.getTransactionId());
        transactionResponse.setMessage(message);

        return transactionResponse;
    }

}
