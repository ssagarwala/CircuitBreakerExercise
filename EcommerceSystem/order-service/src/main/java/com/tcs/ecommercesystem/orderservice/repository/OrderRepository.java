package com.tcs.ecommercesystem.orderservice.repository;

import com.tcs.ecommercesystem.orderservice.entity.Inventory;
import com.tcs.ecommercesystem.orderservice.entity.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends MongoRepository<Order, String> {
   // Order findById(String orderId);
}