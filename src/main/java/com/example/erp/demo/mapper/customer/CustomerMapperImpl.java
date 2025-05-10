package com.example.erp.demo.mapper.customer;

import com.example.erp.demo.model.dto.customer.CustomerRequestDto;
import com.example.erp.demo.model.dto.customer.CustomerResponseDto;
import com.example.erp.demo.model.entity.customer.Customer;

public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public CustomerResponseDto toCustomerDtoFromCustomerEntity(Customer customer) {
        return null;
    }

    @Override
    public Customer toCustomerEntityFromCustomerDto(CustomerRequestDto customerRequestDto) {
        return null;
    }
}
