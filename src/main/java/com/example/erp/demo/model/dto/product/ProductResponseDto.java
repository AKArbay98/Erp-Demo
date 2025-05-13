package com.example.erp.demo.model.dto.product;

import com.example.erp.demo.model.dto.license.LicenseResponseDto;
import com.example.erp.demo.model.dto.producer.ProducerResponseDto;
import com.example.erp.demo.model.entity.address.Address;
import com.example.erp.demo.model.entity.license.License;
import com.example.erp.demo.model.entity.producer.Producer;
import com.example.erp.demo.model.entity.product.Product;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class ProductResponseDto {

    private String name;
    private String productVersion;
    private String description;
    private String sku;
    private BigDecimal basePrice;
    private BigDecimal discountedPrice;
    private LocalDateTime releaseDate;
    private LocalDate supportExpiration;
    private BigDecimal customerSatisfaction;
    private String comment;
    private List<LicenseResponseDto> licenses;
    private ProducerResponseDto producer;
}
