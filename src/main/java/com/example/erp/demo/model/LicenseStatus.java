package com.example.erp.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public enum LicenseStatus {

    ACTIVE("ACTIVE"),
    EXPIRED("EXPIRED"),
    REVOKED("EXPIRED");

    private final String licenseStatusName;

}
