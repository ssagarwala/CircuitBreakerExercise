package com.tcs.ecommercesystem.inventoryservice.service;

import com.tcs.ecommercesystem.inventoryservice.entity.Inventory;
import com.tcs.ecommercesystem.inventoryservice.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class InventoryService {

    @Autowired
    InventoryRepository inventoryRepository;

      public Optional<Inventory> getItemByName(String name) {

       return inventoryRepository.findByName(name);
    }

     public List<Inventory> getAllItems() {
         return inventoryRepository.findAll();
     }
}
