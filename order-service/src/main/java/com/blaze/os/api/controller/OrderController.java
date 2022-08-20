package com.blaze.os.api.controller;

import com.blaze.os.api.common.TransactionRequest;
import com.blaze.os.api.common.TransactionResponse;
import com.blaze.os.api.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //RestController annotation
@RequestMapping("/order") //if request contains /order
public class OrderController {

    @Autowired
    private OrderService service;

    Logger logger = LoggerFactory.getLogger(OrderController.class);

    @PostMapping("/bookOrder") //if post request contains /order
    public TransactionResponse bookOrder(@RequestBody TransactionRequest request){ //@RequestBody annotation will convert the HttpRequest body into Java object
        return service.saveOrder(request);
    }

}
