package com.example.erp.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;


@Entity
@Table(name = "customer")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode(callSuper = false)
public class Customer extends BaseEntity{

    @Column(name = "firstName", nullable = false)
    private String firstName;

    @Column(name = "lastName", nullable = false)
    private String lastName;

    @Column(name = "dateOfBirth", nullable = false)
    private LocalDate dateOfBirth;

    @Column(name = "tc", nullable = false)
    private String tc;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "email")
    private String email;

    @Column(name = "photoUrl")
    private String photoUrl;

    @Column(name = "occupation")
    private String occupation;

    @Column(name = "language")
    private String language;

    // enums
    // private Gender gender;


    // private ContactMethod contactMethod;


    //private CustomerType customerType;

    //relation
    // private Address address;
    // private List<License> licenses;

}
