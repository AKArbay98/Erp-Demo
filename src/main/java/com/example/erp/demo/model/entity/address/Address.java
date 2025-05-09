package com.example.erp.demo.model.entity.address;

import com.example.erp.demo.model.entity.BaseEntity;
import com.example.erp.demo.model.entity.customer.Customer;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "address")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@EqualsAndHashCode(callSuper = false)
public class Address extends BaseEntity {

    @Column(name = "country",
            length = 50,
            nullable = false)
    private String country;

    @Column(name = "city",
            length = 50,
            nullable = false)
    private String city;

    @Column(name = "state_province",
            length = 50,
            nullable = false)
    private String stateProvince;

    @Column(name = "district",
            length = 50,
            nullable = false)
    private String district;

    @Column(name = "street_address",
            length = 100)
    private String streetAddress;

    @Column(name = "address_line_two",
            length = 100)
    private String addressLineTwo;

    @Column(name = "postal_code",
            nullable = false)
    private String postalCode;

    @Column(name = "verified",
            nullable = false)
    private Boolean isVerified;


    // relation
    @OneToOne(
            mappedBy = "address",
            fetch = FetchType.LAZY,
            optional = false
    )
    private Customer customer;


//    private Producer producer;

}
