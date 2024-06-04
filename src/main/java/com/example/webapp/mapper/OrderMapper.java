//package com.example.webapp.mapper;
//
//import com.example.webapp.rest.dto.OrderDto;
//import com.example.webapp.model.Order;
//import com.example.webapp.model.OrderItem;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class OrderMapper {
//
//    public static OrderDto orderToDto(Order order) {
//        OrderDto orderDto = new OrderDto();
//        orderDto.setId(order.getId());
//        List<OrderItemsInnerDto> orderItemsDtos = new ArrayList<>();
//        for (OrderItem orderItem : order.getItems()) {
//            OrderItemsInnerDto orderItemDto = new OrderItemsInnerDto();
//            orderItemDto.setId(orderItem.getId());
//            orderItemDto.setQuantity(orderItem.getQuantity());
//            orderItemsDtos.add(orderItemDto);
//        }
//        orderDto.setItems(orderItemsDtos);
//        return orderDto;
//    }
//
//    public static Order dtoToOrder(OrderDto orderDto) {
//        Order order = new Order();
//        order.setId(orderDto.getId());
//        List<OrderItem> orderItems = new ArrayList<>();
//        for (OrderItemsInnerDto orderItemDto : orderDto.getItems()) {
//            OrderItem orderItem = new OrderItem();
//            orderItem.setId(orderItemDto.getId());
//            orderItem.setQuantity(orderItemDto.getQuantity());
//            orderItems.add(orderItem);
//        }
//        order.setItems(orderItems);
//        return order;
//    }
//}
