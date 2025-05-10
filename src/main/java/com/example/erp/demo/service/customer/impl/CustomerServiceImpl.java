package com.example.erp.demo.service.customer.impl;

import com.example.erp.demo.exception.CustomerNotFoundException;
import com.example.erp.demo.mapper.customer.CustomerMapperImpl;
import com.example.erp.demo.model.dto.customer.CustomerRequestDto;
import com.example.erp.demo.model.dto.customer.CustomerResponseDto;
import com.example.erp.demo.model.entity.customer.Customer;
import com.example.erp.demo.repository.CustomerRepository;
import com.example.erp.demo.service.customer.CustomerService;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapperImpl customerMapper;


    public CustomerServiceImpl(CustomerRepository customerRepository,
                               CustomerMapperImpl customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    @Override
    public List<CustomerResponseDto> getAllCustomer() {
        List<Customer> customers = customerRepository.findAll();
        if(customers.isEmpty()){
            throw new CustomerNotFoundException("No customers found.");
        }
        List<CustomerResponseDto> customerResponseDtoList = new ArrayList<>();
        for(Customer customer : customers){
            CustomerResponseDto customerResponseDto = customerMapper
                    .toCustomerDtoFromCustomerEntity(customer);
            customerResponseDtoList.add(customerResponseDto);
        }
        return customerResponseDtoList;
    }

    @Override
    public CustomerResponseDto getCustomerById(Long customerId) {
        Customer customer = customerRepository.findById(customerId).orElse(null);
        if(customer == null){
            throw new CustomerNotFoundException("No customers found.");
        }
        return customerMapper.toCustomerDtoFromCustomerEntity(customer);
    }

    @Override
    public void createCustomer(CustomerRequestDto customerRequestDto) {
        Customer customer = customerMapper.toCustomerEntityFromCustomerDto(customerRequestDto);
        customerRepository.save(customer);
    }

}
