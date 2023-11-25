package com.tcs.ecommercesystem.orderservice.service;

import com.tcs.ecommercesystem.orderservice.entity.Inventory;
import com.tcs.ecommercesystem.orderservice.entity.Order;
import com.tcs.ecommercesystem.orderservice.repository.OrderRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;
import java.util.UUID;

@Service
public class OrderService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    OrderRepository orderRepository;

    private static final String SERVICE_NAME = "loan-service";

    private static final String RATE_SERVICE_URL = "http://localhost:9000/api/rates/";

    public Optional<Order> getOrderById(String orderId) {
        return orderRepository.findById(orderId);
    }


    @CircuitBreaker(name = SERVICE_NAME, fallbackMethod = "getDefaultOrder")
    public Order createOrder(String inventoryName) {
        Inventory inventory = restTemplate.getForObject("http://localhost:8081/inventory-service/inventory/" + inventoryName,
                Inventory.class);
        Order order = null;
        if (inventory != null) {
            order = Order.builder().id(UUID.randomUUID().toString()).inventory(inventory).build();
            orderRepository.save(order);
        }
        return order;
    }

    public Order getDefaultOrder(String type, Exception e) {
        return new Order();
    }
}
