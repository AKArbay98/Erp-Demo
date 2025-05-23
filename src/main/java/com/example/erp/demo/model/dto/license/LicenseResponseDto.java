package com.example.erp.demo.model.dto.license;

import com.example.erp.demo.model.dto.customer.CustomerResponseDto;
import com.example.erp.demo.model.dto.product.ProductResponseDto;
import com.example.erp.demo.model.enumeration.LicenseStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class LicenseResponseDto {

    private String licenseKey;
    private String licenseName;
    private LocalDate startDate;
    private LocalDate endDate;
    private Boolean autoRenew;
    private LicenseStatus licenseStatus;
    private String licenseDetail;
    private CustomerResponseDto customer;
    private ProductResponseDto product;
}
