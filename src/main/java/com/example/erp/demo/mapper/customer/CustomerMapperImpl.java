package com.example.erp.demo.mapper.customer;

import com.example.erp.demo.mapper.address.AddressMapper;
import com.example.erp.demo.mapper.license.LicenseMapper;
import com.example.erp.demo.model.dto.customer.CustomerRequestDto;
import com.example.erp.demo.model.dto.customer.CustomerResponseDto;
import com.example.erp.demo.model.entity.customer.Customer;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapperImpl implements CustomerMapper {

    private final AddressMapper addressMapper;
    private final LicenseMapper licenseMapper;

    public CustomerMapperImpl(@Lazy AddressMapper addressMapper,
                              @Lazy LicenseMapper licenseMapper) {
        this.addressMapper = addressMapper;
        this.licenseMapper = licenseMapper;
    }

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
        if (customerRequestDto.getAddress() != null) {
            customer.setAddress(addressMapper
                    .toAddressEntityFromAddressDto(customerRequestDto.getAddress()));
        }
        return customer;
    }
}
