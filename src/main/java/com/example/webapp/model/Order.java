package com.example.webapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private String id;
    private String username;
    private String orderDate;
    private String productName;
    private int quantity;
    private double totalPrice;
    private String address;
    private String phone;
    private String img;
}
