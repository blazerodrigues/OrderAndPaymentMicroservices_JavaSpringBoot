package com.blaze.ps.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PAYMENT_TB")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {

    @Id
    @GeneratedValue //this will autogenerate the id
    private int paymentId;
    private String paymentStatus;
    private String transactionId;

    private int orderId; //this will be passed by order service to payment service
    private double amount; //this will be passed by order service to payment service

}
