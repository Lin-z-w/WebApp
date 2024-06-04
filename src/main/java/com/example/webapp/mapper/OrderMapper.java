package com.example.webapp.mapper;

import com.example.webapp.rest.dto.OrderDto;
import com.example.webapp.model.Order;
import com.example.webapp.model.OrderItem;

import java.util.ArrayList;
import java.util.List;

public class OrderMapper {

    public static OrderDto orderToDto(Order order) {
        OrderDto orderDto = new OrderDto();
        orderDto.setOrderDate(order.getOrderDate());
        orderDto.setQuantity(order.getQuantity());
        orderDto.setAddress(order.getAddress());
        orderDto.setImg(order.getImg());
        orderDto.setPhone(order.getPhone());
        orderDto.setTotalPrice(order.getTotalPrice());
        return orderDto;
    }
}
