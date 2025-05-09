package com.example.erp.demo.model.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public enum Gender {

    MALE("M","Male"),
    FEMALE("F", "Female");

    private final String code;
    private final String displayName;
}
