package com.example.erp.demo.model.dto.producer;

import com.example.erp.demo.model.dto.address.AddressRequestDto;
import com.example.erp.demo.model.dto.product.ProductRequestDto;
import com.example.erp.demo.model.entity.address.Address;
import com.example.erp.demo.model.entity.product.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProducerRequestDto {

    private String name;

    private String description;

    private String contactEmail;

    private String contactPhone;

    private String websiteUrl;

    private List<ProductRequestDto> products;

    private AddressRequestDto address;
}
