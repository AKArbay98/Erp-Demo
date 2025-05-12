package com.example.erp.demo.model.dto.address;

import com.example.erp.demo.model.dto.customer.CustomerResponseDto;
import com.example.erp.demo.model.dto.producer.ProducerResponseDto;
import com.example.erp.demo.model.entity.customer.Customer;
import com.example.erp.demo.model.entity.producer.Producer;
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
    private CustomerResponseDto customer;
    private ProducerResponseDto producer;
}
