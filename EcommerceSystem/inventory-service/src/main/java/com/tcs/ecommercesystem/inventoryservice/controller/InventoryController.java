package com.tcs.ecommercesystem.inventoryservice.controller;

import com.tcs.ecommercesystem.inventoryservice.entity.Item;
import com.tcs.ecommercesystem.inventoryservice.service.InventoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    private static final Logger log = LoggerFactory.getLogger(InventoryController.class);
    @Autowired
    private InventoryService inventoryService;

    @GetMapping(path = "/item/{id}")
    public ResponseEntity<Item> getInventoryById(@PathVariable("id") String id) {
        System.out.println("In Inventory controller with id:"+ id);
        return ResponseEntity.ok().body(inventoryService.getItemById(id));
    }
}