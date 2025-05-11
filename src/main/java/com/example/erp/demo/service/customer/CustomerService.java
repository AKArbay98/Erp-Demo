package com.example.erp.demo.service.customer;

import com.example.erp.demo.model.dto.customer.CustomerRequestDto;
import com.example.erp.demo.model.dto.customer.CustomerResponseDto;

import java.util.List;

public interface CustomerService {

    List<CustomerResponseDto> getAllCustomer();

    CustomerResponseDto getCustomerById(Long customerId);

    void createCustomer(CustomerRequestDto customerRequestDto);

    CustomerResponseDto getCustomerByLicenseKey(String licenseKey);
}
