# OrderAndPaymentMicroservices_SpringBoot

Created two microservices using Java Spring Boot - Order service and Payment Service <br/> 

Order Service:<br/>
<img width="960" alt="image" src="https://user-images.githubusercontent.com/96373227/185761628-d77d44f8-97d8-4023-9e98-bd1a3101e1f1.png">

Payment Service:<br/>
<img width="960" alt="image" src="https://user-images.githubusercontent.com/96373227/185761652-0b8c280f-bf7b-495a-bc1c-3af80c1f9a2d.png">

Using H2-database to store data: <br/>
<img width="960" alt="image" src="https://user-images.githubusercontent.com/96373227/185762165-a584b4af-cfe5-44ec-bdf0-432701551e6d.png">

All microservices registered on EUREKA service registry:<br/>
<img width="960" alt="image" src="https://user-images.githubusercontent.com/96373227/185761974-3746e9b3-f0eb-4f1f-a392-5568745a5680.png">

Hystrix Fallback in case any microservice fails:<br/>
<img width="960" alt="image" src="https://user-images.githubusercontent.com/96373227/185761865-add9be15-f496-47a9-9204-ce77a9149fab.png">

Cloud gateway has hystrix stream enabled, sending data to Hystrix dashboard: <br/>
<img width="960" alt="image" src="https://user-images.githubusercontent.com/96373227/185762068-432948b0-5da1-437d-8a23-b2fb5f853471.png">
<img width="960" alt="image" src="https://user-images.githubusercontent.com/96373227/185762118-3b3ec53a-5238-4146-8325-ec223dab3741.png">

Cloud config server to get common properties from GitHub: <br/>
<img width="960" alt="image" src="https://user-images.githubusercontent.com/96373227/185762310-6eddba9b-463b-4648-b6a4-54cd5a5d5cb2.png">

Implementing centralized logging using ELK stack (Elasticsearch-Logstash-Kibana): <br/>
<img width="959" alt="image" src="https://user-images.githubusercontent.com/96373227/185762509-ef36a181-759a-4c85-9a05-56c69a0781db.png">

Distributed Tracing using Sleuth and Zipkin: <br/>
Notice that the TRACE ID ba0a1614d5ae7933 is same in ORDER-SERVICE and PAYMENT-SERVICE (Order service calls Payment service)<br/>
ORDER-SERVICE LOGS<br/>
2022-08-21 00:34:45.416  INFO [ORDER-SERVICE,ba0a1614d5ae7933,ba0a1614d5ae7933] 23580 --- [nio-9192-exec-2] com.blaze.os.api.service.OrderService    : OrderService saveOrder REQUEST: {"order":{"id":0,"name":"Mobile","qty":1,"price":8000.0},"payment":{"paymentId":0,"paymentStatus":null,"transactionId":null,"orderId":0,"amount":0.0}} <br/>
2022-08-21 00:34:45.664  INFO [ORDER-SERVICE,ba0a1614d5ae7933,ba0a1614d5ae7933] 23580 --- [nio-9192-exec-2] com.blaze.os.api.service.OrderService    : OrderService saveOrder (PaymentService call) RESPONSE: {"paymentId":3,"paymentStatus":"success","transactionId":"a1dfb00a-73a3-4de2-afb2-582e5b1bedbc","orderId":1,"amount":8000.0} <br/>
PAYMENT-SERVICE LOGS <br/>
2022-08-21 00:34:45.650  INFO [PAYMENT-SERVICE,ba0a1614d5ae7933,f90362eb4448f801] 2004 --- [nio-9191-exec-5] com.blaze.ps.api.service.PaymentService  : PaymentService doPayment PAYMENT: {"paymentId":0,"paymentStatus":"success","transactionId":"a1dfb00a-73a3-4de2-afb2-582e5b1bedbc","orderId":1,"amount":8000.0} <br/>
<img width="956" alt="image" src="https://user-images.githubusercontent.com/96373227/185762736-0f4e996c-c733-4dc2-803e-4cb5f6255227.png"> <br/>
