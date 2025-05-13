package com.example.erp.demo.model.dto.customer;

import com.example.erp.demo.model.dto.address.AddressRequestDto;
import com.example.erp.demo.model.enumeration.ContactMethod;
import com.example.erp.demo.model.enumeration.CustomerType;
import com.example.erp.demo.model.enumeration.Gender;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
public class CustomerRequestDto {

    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String tc;
    private String phone;
    private String email;
    private String photoUrl;
    private String occupation;
    private String language;
    private Gender gender;
    private ContactMethod contactMethod;
    private CustomerType customerType;
    private AddressRequestDto address;
}
