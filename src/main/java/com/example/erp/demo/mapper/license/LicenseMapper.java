package com.example.erp.demo.mapper.license;

import com.example.erp.demo.model.dto.license.LicenseRequestDto;
import com.example.erp.demo.model.dto.license.LicenseResponseDto;
import com.example.erp.demo.model.entity.license.License;

public interface LicenseMapper {
    LicenseResponseDto toLicenseDtoFromLicenseEntity(License license);
    License toLicenseEntityFromLicenseDto(LicenseRequestDto licenseRequestDto);
}
