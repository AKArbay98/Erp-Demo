package com.example.erp.demo.exception;

public class LicenseNotFoundException extends RuntimeException {

    public LicenseNotFoundException(Long licenseId) {
        super("License with ID " + licenseId + " does not exist.");
    }

    public LicenseNotFoundException(String message) {
        super(message);
    }
}
