package com.example.erp.demo.model.enumeration;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public enum LicenseStatus {

    ACTIVE("ACTIVE"),
    EXPIRED("EXPIRED"),
    REVOKED("REVOKED");

    private final String licenseStatusName;

    LicenseStatus(String licenseStatusName) {
        this.licenseStatusName = licenseStatusName;
    }
}
