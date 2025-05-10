package com.example.erp.demo.service.customer.impl;

import com.example.erp.demo.mapper.customer.CustomerMapperImpl;
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
        List<Customer> customerList = customerRepository.findAll();
        if(customerList == null || customerList.isEmpty()){
            throw new IllegalArgumentException("Customer does not exist.");
        }
        List<CustomerResponseDto> customerResponseDtoList = new ArrayList<>();
        for(Customer customer : customerList){
            CustomerResponseDto customerResponseDto = customerMapper
                    .toCustomerDtoFromCustomerEntity(customer);
            customerResponseDtoList.add(customerResponseDto);
        }
        return customerResponseDtoList;
    }
}
