package com.example.erp.demo.service.license;

import com.example.erp.demo.model.dto.license.LicenseRequestDto;

public interface LicenseService {

    boolean isValidLicenseKey(String licenseKey);

    String createLicenseKey(Long customerId, Long productId);
}
