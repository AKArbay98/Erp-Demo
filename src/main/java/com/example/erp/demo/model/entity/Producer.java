package com.example.erp.demo.model.entity;


import com.example.erp.demo.model.entity.address.Address;
import com.example.erp.demo.model.entity.product.Product;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.validator.constraints.URL;

import java.util.List;


@Entity
@Table(name = "producer")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = false)
public class Producer extends BaseEntity{

    @NotBlank(message = "Producer name is required")
    @Size(max = 150, message = "Producer name cannot exceed 150 characters")
    @Column(name = "name", nullable = false, length = 150)
    private String name;

    @Size(max = 500, message = "Description cannot exceed 500 characters")
    @Column(name = "description")
    private String description;

    @Email(message = "Must be a valid email address")
    @Column(name = "contact-mail", length = 120)
    private String contactEmail;

    @Column(name = "contact-phone", length = 20)
    private String contactPhone;

    @URL(message = "Must be a valid URL")
    @Column(name = "website", length = 200)
    private String websiteUrl;


    // relation
    @OneToMany(
            mappedBy = "producer",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private List<Product> products;


    @OneToOne(
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            optional = false
    )
    @JoinColumn(
            name = "address_id",
            nullable = false,
            unique = true,
            foreignKey = @ForeignKey(name = "fk_producer_address")
    )
    private Address address;

}
