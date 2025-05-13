package com.example.erp.demo.model.enumeration;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public enum Gender {

    MALE("M","Male"),
    FEMALE("F", "Female");

    private final String code;
    private final String displayName;

    Gender(String code, String displayName) {
        this.code = code;
        this.displayName = displayName;
    }
}
