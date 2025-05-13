package com.example.erp.demo.mapper.license;

import com.example.erp.demo.mapper.customer.CustomerMapper;
import com.example.erp.demo.mapper.product.ProductMapper;
import com.example.erp.demo.model.dto.license.LicenseRequestDto;
import com.example.erp.demo.model.dto.license.LicenseResponseDto;
import com.example.erp.demo.model.entity.license.License;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;


@Component
public class LicenseMapperImpl implements LicenseMapper{

    private final CustomerMapper customerMapper;
    private final ProductMapper productMapper;

    public LicenseMapperImpl(@Lazy CustomerMapper customerMapper,
                             @Lazy ProductMapper productMapper) {
        this.customerMapper = customerMapper;
        this.productMapper = productMapper;
    }

    @Override
    public LicenseResponseDto toLicenseDtoFromLicenseEntity(License license){
        LicenseResponseDto licenseResponseDto = new LicenseResponseDto();
        licenseResponseDto.setLicenseKey(license.getLicenseKey());
        licenseResponseDto.setLicenseName(license.getLicenseName());
        licenseResponseDto.setStartDate(license.getStartDate());
        licenseResponseDto.setEndDate(license.getEndDate());
        licenseResponseDto.setAutoRenew(license.getAutoRenew());
        licenseResponseDto.setLicenseStatus(license.getLicenseStatus());
        licenseResponseDto.setLicenseDetail(license.getLicenseDetail());
        if (license.getCustomer() != null) {
            licenseResponseDto.setCustomer(customerMapper
                    .toCustomerDtoFromCustomerEntity(license.getCustomer()));
        }
        if (license.getProduct() != null) {
            licenseResponseDto.setProduct(productMapper
                    .toProductDtoFromProductEntity(license.getProduct()));
        }
        return licenseResponseDto;
    }

    @Override
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
        if (licenseRequestDto.getCustomer() != null) {
            license.setCustomer(customerMapper
                    .toCustomerEntityFromCustomerDto(licenseRequestDto.getCustomer()));
        }
        if (licenseRequestDto.getProduct() != null) {
            license.setProduct(productMapper
                    .toProductEntityFromProductDto(licenseRequestDto.getProduct()));
        }
        return license;
    }



}
