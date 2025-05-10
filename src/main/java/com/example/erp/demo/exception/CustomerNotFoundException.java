package com.example.erp.demo.exception;

public class CustomerNotFoundException extends RuntimeException{

    public CustomerNotFoundException(Long customerId) {
        super("Customer with ID " + customerId + " does not exist.");
    }

    public CustomerNotFoundException(String message) {
        super(message);
    }
}
