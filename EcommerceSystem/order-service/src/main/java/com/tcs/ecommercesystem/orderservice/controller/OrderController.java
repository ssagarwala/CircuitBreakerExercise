package com.tcs.ecommercesystem.orderservice.controller;

import com.tcs.ecommercesystem.orderservice.entity.Order;
import com.tcs.ecommercesystem.orderservice.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;
    private static final Logger log = LoggerFactory.getLogger(OrderController.class);

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Order> getOrderById(@PathVariable("id") String orderId) {
        log.info("Retrieve Order by Order Id");
        return ResponseEntity.ok().body(orderService.getOrderById(orderId));
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        log.info("Createing Orders");
        Order orderToBePlaced = null;
        return ResponseEntity.ok().body(orderService.createOrder(order));
    }
}
