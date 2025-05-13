package com.example.erp.demo.model.enumeration;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public enum CustomerType {

    PERSONAL("PERSONAL"),
    CORPORATE("CORPORATE");

    private final String customerTypeName;

    CustomerType(String customerTypeName) {
        this.customerTypeName = customerTypeName;
    }
}
