package com.example.erp.demo.model.dto.producer;

import com.example.erp.demo.model.dto.address.AddressResponseDto;
import com.example.erp.demo.model.dto.product.ProductResponseDto;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class ProducerResponseDto {
    private String name;
    private String description;
    private String contactEmail;
    private String contactPhone;
    private String websiteUrl;
    private List<ProductResponseDto> products;
    private AddressResponseDto address;
}
