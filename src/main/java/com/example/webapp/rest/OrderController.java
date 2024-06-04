package com.example.webapp.rest;

import com.example.webapp.rest.api.OrderApi;
import com.example.webapp.rest.dto.CreateOrder200ResponseDto;
import com.example.webapp.rest.dto.OrderDto;
import com.example.webapp.rest.dto.OrderListDto;
import com.example.webapp.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController implements OrderApi {

    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public ResponseEntity<OrderDto> showOrderById(String orderId) {
        return OrderApi.super.showOrderById(orderId);
    }

    @Override
    public ResponseEntity<CreateOrder200ResponseDto> createOrder(OrderListDto orderListDto) {
        System.out.println("Creating order: " + orderListDto);
        try {
            orderService.createOrder(orderListDto);
            return new ResponseEntity<>(new CreateOrder200ResponseDto().code(1), HttpStatus.CREATED);
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
