package com.example.erp.demo.model.entity.customer;

import com.example.erp.demo.model.entity.BaseEntity;
import com.example.erp.demo.model.entity.license.License;
import com.example.erp.demo.model.entity.address.Address;
import com.example.erp.demo.model.enumeration.ContactMethod;
import com.example.erp.demo.model.enumeration.CustomerType;
import com.example.erp.demo.model.enumeration.Gender;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;


@Entity
@Table(name = "customer")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = false)
public class Customer extends BaseEntity {

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "date_of_birth", nullable = false)
    private LocalDate dateOfBirth;

    @Column(name = "tc", nullable = false)
    private String tc;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "email")
    private String email;

    @Column(name = "photo_url")
    private String photoUrl;

    @Column(name = "occupation")
    private String occupation;

    @Column(name = "language")
    private String language;

    // enums
    @Enumerated(EnumType.STRING)
    @Column(name = "gender", nullable = false)
    private Gender gender;

    @Enumerated(EnumType.STRING)
    @Column(name = "contact_method", nullable = false)
    private ContactMethod contactMethod;

    @Enumerated(EnumType.STRING)
    @Column(name = "customer_type", nullable = false)
    private CustomerType customerType;

    //relation
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
            foreignKey = @ForeignKey(name = "fk_customer_address")
    )
    private Address address;


    @OneToMany(
            mappedBy = "customer",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private List<License> licenses;

}
