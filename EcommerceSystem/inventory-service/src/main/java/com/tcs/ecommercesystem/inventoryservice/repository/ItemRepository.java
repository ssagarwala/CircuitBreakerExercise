package com.tcs.ecommercesystem.inventoryservice.repository;

import com.tcs.ecommercesystem.inventoryservice.entity.Item;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ItemRepository extends MongoRepository<Item, String> {
    Optional<Item> findById(String id);

}