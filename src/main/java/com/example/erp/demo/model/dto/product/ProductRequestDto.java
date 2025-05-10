package com.example.erp.demo.model.dto.product;

import com.example.erp.demo.model.entity.address.Address;
import com.example.erp.demo.model.entity.product.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProductRequestDto {

    private String name;

    private String description;

    private String contactEmail;

    private String contactPhone;

    private String websiteUrl;

    private List<Product> products;

    private Address address;
}
