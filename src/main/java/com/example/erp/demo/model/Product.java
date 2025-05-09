package com.example.erp.demo.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "product")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = false)
public class Product extends BaseEntity{

    @Column(name = "name")
    private String name;

    @Column(name = "product-version")
    private String productVersion;

    @Column(name = "description")
    private String description;

    @Column(name = "sku")
    private String sku;

    @Column(name = "base-price")
    private BigDecimal basePrice;

    @Column(name = "discounted-price")
    private BigDecimal discountedPrice;

    @Column(name = "release-date")
    private LocalDateTime releaseDate;

    @Future
    @Column(name = "support-expiration")
    private LocalDate supportExpiration;

    @Column(name = "customer-satisfaction")
    private BigDecimal customerSatisfaction;

    @Column(name = "comment")
    private String comment;

    // relation
//    private List<License> licenses;
//    private Producer producer;


}
