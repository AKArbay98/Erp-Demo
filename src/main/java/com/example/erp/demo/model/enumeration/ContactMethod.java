package com.example.erp.demo.model.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public enum ContactMethod {

    EMAIL("EMAIL"),
    PHONE("PHONE"),
    POST("POST");

    private final String contactMethodName;
}
