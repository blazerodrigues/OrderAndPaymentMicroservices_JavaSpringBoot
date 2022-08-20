package com.blaze.cloud.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableEurekaClient //To register this on EUREKA SERVER as a CLIENT
@EnableHystrix //Hystrix
public class CloudGatewayApplication {
	public static void main(String[] args) {
		SpringApplication.run(CloudGatewayApplication.class, args);
	}

}
