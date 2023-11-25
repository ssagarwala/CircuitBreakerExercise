package com.tcs.ecommercesystem.orderservice.exception;

public class InventoryNotFoundException extends RuntimeException {
    public InventoryNotFoundException(String message) {
        super(message);
    }
}
