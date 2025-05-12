package com.example.erp.demo.model.dto.address;

import com.example.erp.demo.model.dto.customer.CustomerRequestDto;
import com.example.erp.demo.model.dto.producer.ProducerRequestDto;
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
    private CustomerRequestDto customer;
    private ProducerRequestDto producer;
}
