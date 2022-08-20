package com.blaze.os.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity //Entity annotation
@Table(name="ORDER_TB") //Table annotation
@Data //lombok getter setter
@AllArgsConstructor //lombok all args constructor
@NoArgsConstructor //lombok no args constructor
public class Order {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private int qty;
    private double price;


}
