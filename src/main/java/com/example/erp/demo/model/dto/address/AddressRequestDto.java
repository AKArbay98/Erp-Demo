package com.example.erp.demo.model.dto.address;

import com.example.erp.demo.model.entity.customer.Customer;
import com.example.erp.demo.model.entity.producer.Producer;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressRequestDto {
    private String country;
    private String city;
    private String stateProvince;
    private String district;
    private String streetAddress;
    private String addressLineTwo;
    private String postalCode;
    private Boolean isVerified;
    private Customer customer;
    private Producer producer;
}
