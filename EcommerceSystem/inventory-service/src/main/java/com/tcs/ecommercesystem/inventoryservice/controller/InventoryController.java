package com.tcs.ecommercesystem.inventoryservice.controller;

import com.tcs.ecommercesystem.inventoryservice.entity.Inventory;
import com.tcs.ecommercesystem.inventoryservice.service.InventoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    private static final Logger log = LoggerFactory.getLogger(InventoryController.class);
    @Autowired
    private InventoryService inventoryService;

    @GetMapping(value = "/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Inventory> getItemByName(@PathVariable("name") String name) {
        log.info("Retrieve Inventory by Inventory name");
       return inventoryService.getItemByName(name);
    }
}