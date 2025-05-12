package com.example.erp.demo.mapper.license;

import com.example.erp.demo.model.dto.license.LicenseRequestDto;
import com.example.erp.demo.model.dto.license.LicenseResponseDto;
import com.example.erp.demo.model.entity.license.License;
import com.example.erp.demo.model.enumeration.LicenseStatus;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class LicenseMapperImpl implements LicenseMapper{


    public LicenseResponseDto toLicenseDtoFromLicenseEntity(License license){
        LicenseResponseDto licenseResponseDto = new LicenseResponseDto();
        licenseResponseDto.setLicenseKey(license.getLicenseKey());
        licenseResponseDto.setLicenseName(license.getLicenseName());
        licenseResponseDto.setStartDate(license.getStartDate());
        licenseResponseDto.setEndDate(license.getEndDate());
        licenseResponseDto.setAutoRenew(license.getAutoRenew());
        licenseResponseDto.setLicenseStatus(license.getLicenseStatus());
        licenseResponseDto.setLicenseDetail(license.getLicenseDetail());

        // relation lara da bak

        return licenseResponseDto;
    }


    public License toLicenseEntityFromLicenseDto(LicenseRequestDto licenseRequestDto){
        if(licenseRequestDto == null){
            return null;
        }
        License license = new License();
        license.setLicenseKey(license.getLicenseKey());
        license.setLicenseName(license.getLicenseName());
        license.setStartDate(license.getStartDate());
        license.setEndDate(license.getEndDate());
        license.setAutoRenew(license.getAutoRenew());
        license.setLicenseStatus(license.getLicenseStatus());
        license.setLicenseDetail(license.getLicenseDetail());

        // relation lara da bak

        return license;
    }



}
