package com.tcs.ecommercesystem.orderservice.controller;

import com.tcs.ecommercesystem.orderservice.entity.Inventory;
import com.tcs.ecommercesystem.orderservice.entity.Order;
import com.tcs.ecommercesystem.orderservice.exception.InternalServerErrorException;
import com.tcs.ecommercesystem.orderservice.exception.InventoryNotFoundException;
import com.tcs.ecommercesystem.orderservice.service.OrderService;
import org.apache.coyote.BadRequestException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;
    private static final Logger log = LoggerFactory.getLogger(OrderController.class);

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Order> getOrderById(@PathVariable("id") String orderId) {
        log.info("Retrieve Order by Order Id");
        return orderService.getOrderById(orderId);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createOrder(@RequestBody Order order) {
        log.info("Createing Orders");
        Order orderToBePlaced = null;
        try {
            orderToBePlaced = orderService.createOrder(order.getInventory().getName());
        } catch (InventoryNotFoundException e) {
            return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
        } catch (InternalServerErrorException e) {
            return new ResponseEntity<>("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
        }  catch (Exception e) {
            return new ResponseEntity<>("An error occurred", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(orderToBePlaced.getId(), HttpStatus.CREATED);
    }


}
