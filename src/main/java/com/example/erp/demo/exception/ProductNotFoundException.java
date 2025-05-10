package com.example.erp.demo.exception;

public class ProductNotFoundException extends RuntimeException {

    public ProductNotFoundException(Long productId) {
        super("Product with ID " + productId + " does not exist.");
    }

    public ProductNotFoundException(String message) {
        super(message);
    }
}
