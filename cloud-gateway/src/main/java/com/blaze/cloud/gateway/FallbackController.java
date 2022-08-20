package com.blaze.cloud.gateway;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class FallbackController {

    //If there is a failure in the ORDER service, request will be REDIRECTED to /orderFallback
    @RequestMapping("/orderFallback")
    public Mono<String> orderServiceFallback(){
        return Mono.just("Fallback message: ORDER service is down");
    }

    @RequestMapping("/paymentFallback")
    public Mono<String> paymentServiceFallback(){
        return Mono.just("Fallback message: PAYMENT service is down");
    }

}
