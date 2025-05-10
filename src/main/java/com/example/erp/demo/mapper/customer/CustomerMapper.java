package com.example.erp.demo.mapper.customer;

import com.example.erp.demo.model.dto.customer.CustomerRequestDto;
import com.example.erp.demo.model.dto.customer.CustomerResponseDto;
import com.example.erp.demo.model.entity.customer.Customer;

public interface CustomerMapper {

    CustomerResponseDto toCustomerDtoFromCustomerEntity(Customer customer);
    Customer toCustomerEntityFromCustomerDto(CustomerRequestDto customerRequestDto);
}
