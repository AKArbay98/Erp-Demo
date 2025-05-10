package com.example.erp.demo.service.license.impl;

import com.example.erp.demo.model.entity.license.License;
import com.example.erp.demo.model.enumeration.LicenseStatus;
import com.example.erp.demo.repository.LicenseRepository;
import com.example.erp.demo.service.license.LicenseService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class LicenseServiceImpl implements LicenseService {

    private final LicenseRepository licenseRepository;

    public LicenseServiceImpl(LicenseRepository licenseRepository) {
        this.licenseRepository = licenseRepository;
    }


    @Override
    public boolean isValidLicenseKey(String licenseKey) {
        License license = licenseRepository.findByLicenseKey(licenseKey).orElse(null);
        return license.getLicenseStatus() == LicenseStatus.ACTIVE &&
                LocalDate.now().isBefore(license.getEndDate()) &&
                LocalDate.now().isAfter(license.getStartDate());
    }
}
