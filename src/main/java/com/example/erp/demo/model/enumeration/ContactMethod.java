package com.example.erp.demo.model.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public enum ContactMethod {

    EMAIL("E-Mail"),
    PHONE("Phone"),
    POST("Post");

    private final String contactMethodName;
}
