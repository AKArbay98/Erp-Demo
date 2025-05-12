package com.example.erp.demo.model.entity.license;

import com.example.erp.demo.model.entity.BaseEntity;
import com.example.erp.demo.model.entity.product.Product;
import com.example.erp.demo.model.entity.customer.Customer;
import com.example.erp.demo.model.enumeration.LicenseStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "license")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@EqualsAndHashCode(callSuper = false)
public class License extends BaseEntity {

    @Column(name = "license_key",
            unique = true,
            nullable = false)
    private String licenseKey;

    @Column(name = "license_name",
            nullable = false)
    private String licenseName;

    @NotNull(message = "Start date is required")
    @Column(name = "start_date",
            nullable = false)
    private LocalDate startDate;

    @NotNull(message = "End date is required")
    @Column(name = "end_date",
            nullable = false)
    private LocalDate endDate;

    @Column(name = "auto_renew")
    private Boolean autoRenew;

    @Column(name = "license_detail")
    private String licenseDetail;

    // enum
    @Enumerated(EnumType.STRING)
    @Column(name = "license_status",
            nullable = false,
            length = 20)
    private LicenseStatus licenseStatus;

    // relation

    @ManyToOne(fetch = FetchType.LAZY,
            optional = false)
    @JoinColumn(name = "customer_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_license_customer"))
    private Customer customer;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
            name = "product_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_license_product")
    )
    private Product product;

}
