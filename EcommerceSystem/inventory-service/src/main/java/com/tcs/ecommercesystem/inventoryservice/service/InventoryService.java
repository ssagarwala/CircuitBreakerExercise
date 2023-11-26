package com.tcs.ecommercesystem.inventoryservice.service;

import com.tcs.ecommercesystem.inventoryservice.entity.Item;
import com.tcs.ecommercesystem.inventoryservice.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class InventoryService {

    @Autowired
    private ItemRepository repository;

    public Item getItemById(String id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Item Not Found: " + id));
    }
}