package com.example.erp.demo.model.dto.product;

import com.example.erp.demo.model.entity.license.License;
import com.example.erp.demo.model.entity.producer.Producer;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class ProductRequestDto {

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

    private List<License> licenses;

    private Producer producer;
}
