package com.example.erp.demo.model.dto.address;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressResponseDto {

    private String country;
    private String city;
    private String stateProvince;
    private String district;
    private String streetAddress;
    private String addressLineTwo;
    private String postalCode;
    private Boolean isVerified;
}
