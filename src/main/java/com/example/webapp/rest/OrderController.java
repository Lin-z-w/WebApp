package com.example.webapp.rest;

import com.example.webapp.rest.api.OrderApi;
import com.example.webapp.rest.dto.OrderDto;
import com.example.webapp.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class OrderController implements OrderApi {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public ResponseEntity<OrderDto> createOrder(@RequestBody OrderDto orderDto) {
        System.out.println("Creating order: " + orderDto);
        try {
            OrderDto createdOrder = orderService.createOrder(orderDto);
            return new ResponseEntity<>(createdOrder, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println("Error creating order: " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    @RequestMapping(value = "/order", method = RequestMethod.OPTIONS)
//    public ResponseEntity<?> handleOptionsRequest() {
//        return ResponseEntity.ok()
//                .header("Access-Control-Allow-Origin", "http://localhost:63342")
//                .header("Access-Control-Allow-Methods", "POST, GET, OPTIONS")
//                .header("Access-Control-Allow-Headers", "Content-Type, Accept")
//                .build();
//    }
}
