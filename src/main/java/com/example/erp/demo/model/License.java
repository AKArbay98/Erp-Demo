package com.example.erp.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedBy;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "license")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@EqualsAndHashCode(callSuper = false)
public class License extends BaseEntity{

    @Column(name = "license-key", unique = true, nullable = false)
    private String licenseKey;

    @Column(name = "license-name")
    private String licenseName;

    @NotNull(message = "Start date is required")
    @Column(name = "start-date", nullable = false)
    private LocalDate startDate;

    @NotNull(message = "End date is required")
    @Column(name = "end-date", nullable = false)
    private LocalDate endDate;

    @Column(name = "auto-renew")
    private Boolean autoRenew;

    @Column(name = "license-detail")
    private String licenseDetail;

    // enum
    @Enumerated(EnumType.STRING)
    @Column(name = "license-status", nullable = false, length = 20)
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
