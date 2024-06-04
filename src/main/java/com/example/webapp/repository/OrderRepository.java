package com.example.webapp.repository;

import com.example.webapp.model.Order;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface OrderRepository {

//    id VARCHAR(255) PRIMARY KEY,
//    orderDate VARCHAR(255),
//    productName VARCHAR(255),
//    quantity INT,
//    totalPrice DOUBLE,
//    address VARCHAR(255),
//    phone VARCHAR(255),
//    img VARCHAR(255)

    @Insert("INSERT INTO orders (id, username, orderDate, productName, quantity, totalPrice, address, phone, img) " +
            "VALUES (#{order.id}, #{order.username} ,#{order.orderDate}, #{order.productName}, #{order.quantity}, #{order.totalPrice}, #{order.address}, #{order.phone}, #{order.img})")
    void save(@Param("order") Order order);


    @Select("SELECT * FROM orders WHERE username = #{username}")
    List<Order> findByUsername(String username);
}
