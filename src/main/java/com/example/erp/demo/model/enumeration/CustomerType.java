package com.example.erp.demo.model.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public enum CustomerType {

    PERSONAL("PERSONAL"),
    CORPORATE("CORPORATE");

    private final String customerTypeName;
}
