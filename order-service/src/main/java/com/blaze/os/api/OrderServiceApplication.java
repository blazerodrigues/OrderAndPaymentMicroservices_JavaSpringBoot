package com.blaze.os.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient //To make this a EUREKA CLIENT (service-registry related)
public class OrderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderServiceApplication.class, args);
	}

	//To do a REST call from one service to another service, we need the REST TEMPLATE in the MAIN APPLICATION CLASS
	@Bean //Bean annotation is used for instantiation
	@LoadBalanced
	public RestTemplate restTemplate(){
		return new RestTemplate(); // we are returning a NEW INSTANCE of RestTemplate
	}

}
