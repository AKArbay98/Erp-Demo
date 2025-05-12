package com.example.erp.demo.model.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public enum LicenseStatus {

    ACTIVE("ACTIVE"),
    EXPIRED("EXPIRED"),
    REVOKED("REVOKED");

    private final String licenseStatusName;

}
