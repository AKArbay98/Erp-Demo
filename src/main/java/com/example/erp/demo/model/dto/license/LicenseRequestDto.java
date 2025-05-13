package com.example.erp.demo.model.dto.license;

import com.example.erp.demo.model.dto.customer.CustomerRequestDto;
import com.example.erp.demo.model.dto.product.ProductRequestDto;
import com.example.erp.demo.model.enumeration.LicenseStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class LicenseRequestDto {

    private String licenseKey;
    private String licenseName;
    private LocalDate startDate;
    private LocalDate endDate;
    private Boolean autoRenew;
    private LicenseStatus licenseStatus;
    private String licenseDetail;
    private CustomerRequestDto customer;
    private ProductRequestDto product;
}
