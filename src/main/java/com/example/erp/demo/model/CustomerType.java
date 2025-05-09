package com.example.erp.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public enum CustomerType {

    PERSONAL("Personal"),
    CORPORATE("Corporate");

    private final String customerTypeName;
}
