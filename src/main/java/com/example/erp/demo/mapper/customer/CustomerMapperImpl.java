package com.example.erp.demo.mapper.customer;

import com.example.erp.demo.model.dto.customer.CustomerRequestDto;
import com.example.erp.demo.model.dto.customer.CustomerResponseDto;
import com.example.erp.demo.model.entity.customer.Customer;
import com.example.erp.demo.model.enumeration.ContactMethod;
import com.example.erp.demo.model.enumeration.CustomerType;
import com.example.erp.demo.model.enumeration.Gender;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public CustomerResponseDto toCustomerDtoFromCustomerEntity(Customer customer) {
        CustomerResponseDto customerResponseDto = new CustomerResponseDto();
        customerResponseDto.setFirstName(customer.getFirstName());
        customerResponseDto.setLastName(customer.getLastName());
        customerResponseDto.setDateOfBirth(customer.getDateOfBirth());
        customerResponseDto.setTc(customer.getTc());
        customerResponseDto.setPhone(customer.getPhone());
        customerResponseDto.setEmail(customer.getEmail());
        customerResponseDto.setPhotoUrl(customer.getPhotoUrl());
        customerResponseDto.setOccupation(customer.getOccupation());
        customerResponseDto.setLanguage(customer.getLanguage());
        customerResponseDto.setGender(customer.getGender());
        customerResponseDto.setContactMethod(customer.getContactMethod());
        customerResponseDto.setCustomerType(customer.getCustomerType());

        // relation lara da bak

        return customerResponseDto;
    }

    @Override
    public Customer toCustomerEntityFromCustomerDto(CustomerRequestDto customerRequestDto) {
        if (customerRequestDto == null) {
            return null;
        }
        Customer customer = new Customer();
        customer.setFirstName(customerRequestDto.getFirstName());
        customer.setLastName(customerRequestDto.getLastName());
        customer.setDateOfBirth(customerRequestDto.getDateOfBirth());
        customer.setTc(customerRequestDto.getTc());
        customer.setPhone(customerRequestDto.getPhone());
        customer.setEmail(customerRequestDto.getEmail());
        customer.setPhotoUrl(customerRequestDto.getPhotoUrl());
        customer.setOccupation(customerRequestDto.getOccupation());
        customer.setLanguage(customerRequestDto.getLanguage());
        customer.setGender(customerRequestDto.getGender());
        customer.setContactMethod(customerRequestDto.getContactMethod());
        customer.setCustomerType(customerRequestDto.getCustomerType());

        // relation lara da bak

        return customer;
    }
}
