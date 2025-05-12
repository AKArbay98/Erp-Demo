package com.example.erp.demo.model.entity.product;


import com.example.erp.demo.model.entity.BaseEntity;
import com.example.erp.demo.model.entity.producer.Producer;
import com.example.erp.demo.model.entity.license.License;
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
public class Product extends BaseEntity {

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "product_version", nullable = false)
    private String productVersion;

    @Column(name = "description")
    private String description;

    @Column(name = "sku")
    private String sku;

    @Column(name = "base_price", nullable = false)
    private BigDecimal basePrice;

    @Column(name = "discounted_price")
    private BigDecimal discountedPrice;

    @Column(name = "release_date")
    private LocalDateTime releaseDate;

    @Future
    @Column(name = "support_expiration")
    private LocalDate supportExpiration;

    @Column(name = "customer_satisfaction")
    private BigDecimal customerSatisfaction;

    @Column(name = "comment")
    private String comment;

    // relation
    @OneToMany(
            mappedBy = "product",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private List<License> licenses;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
            name = "producer_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_product_producer")
    )
    private Producer producer;

}
