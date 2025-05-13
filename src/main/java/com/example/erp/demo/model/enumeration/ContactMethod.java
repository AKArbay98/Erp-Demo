package com.example.erp.demo.model.enumeration;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public enum ContactMethod {

    EMAIL("EMAIL"),
    PHONE("PHONE"),
    POST("POST");

    private final String contactMethodName;

    ContactMethod(String contactMethodName) {
        this.contactMethodName = contactMethodName;
    }
}
