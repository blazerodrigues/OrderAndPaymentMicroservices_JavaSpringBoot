# OrderAndPaymentMicroservices_SpringBoot

Created two microservices using Java Spring Boot - Order service and Payment Service 

Order Service:
<img width="960" alt="image" src="https://user-images.githubusercontent.com/96373227/185761628-d77d44f8-97d8-4023-9e98-bd1a3101e1f1.png">

Payment Service:
<img width="960" alt="image" src="https://user-images.githubusercontent.com/96373227/185761652-0b8c280f-bf7b-495a-bc1c-3af80c1f9a2d.png">

Using H2-database to store data for this demo
<img width="960" alt="image" src="https://user-images.githubusercontent.com/96373227/185762165-a584b4af-cfe5-44ec-bdf0-432701551e6d.png">

All microservices registered on EUREKA service registry
<img width="960" alt="image" src="https://user-images.githubusercontent.com/96373227/185761974-3746e9b3-f0eb-4f1f-a392-5568745a5680.png">

Hystrix Fallback in case any microservice fails
<img width="960" alt="image" src="https://user-images.githubusercontent.com/96373227/185761865-add9be15-f496-47a9-9204-ce77a9149fab.png">

Cloud gateway has hystrix stream enabled, sending data to Hystrix dashboard
<img width="960" alt="image" src="https://user-images.githubusercontent.com/96373227/185762068-432948b0-5da1-437d-8a23-b2fb5f853471.png">
<img width="960" alt="image" src="https://user-images.githubusercontent.com/96373227/185762118-3b3ec53a-5238-4146-8325-ec223dab3741.png">

