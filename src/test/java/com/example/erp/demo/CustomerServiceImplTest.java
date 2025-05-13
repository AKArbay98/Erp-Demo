package com.example.erp.demo;

import com.example.erp.demo.controller.customer.CustomerController;
import com.example.erp.demo.exception.CustomerNotFoundException;
import com.example.erp.demo.exception.LicenseNotFoundException;
import com.example.erp.demo.mapper.address.AddressMapper;
import com.example.erp.demo.mapper.customer.CustomerMapperImpl;
import com.example.erp.demo.model.dto.address.AddressRequestDto;
import com.example.erp.demo.model.dto.customer.CustomerRequestDto;
import com.example.erp.demo.model.dto.customer.CustomerResponseDto;
import com.example.erp.demo.model.entity.address.Address;
import com.example.erp.demo.model.entity.customer.Customer;
import com.example.erp.demo.model.enumeration.ContactMethod;
import com.example.erp.demo.model.enumeration.CustomerType;
import com.example.erp.demo.model.enumeration.Gender;
import com.example.erp.demo.repository.CustomerRepository;
import com.example.erp.demo.repository.LicenseRepository;
import com.example.erp.demo.service.customer.impl.CustomerServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class CustomerServiceImplTest {

    @InjectMocks
    private CustomerController customerController;

    @Mock
    private CustomerRepository customerRepository;

    @Mock
    private CustomerMapperImpl customerMapper;

    @Mock
    private LicenseRepository licenseRepository;

    @InjectMocks
    private CustomerServiceImpl customerService;

    @Mock
    private AddressMapper addressMapper;

    private Customer customer;
    private CustomerResponseDto dto;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        customer = new Customer();
        customer.setId(1L);
        customer.setFirstName("Ali Kaan");
        customer.setLastName("Arbay");
        customer.setDateOfBirth(LocalDate.of(1998, 3, 11));
        customer.setTc("12345678901");
        customer.setPhone("555-1234");
        customer.setEmail("ali.kaan@example.com");
        customer.setPhotoUrl("http://example.com/photo.jpg");
        customer.setOccupation("Software Engineer");
        customer.setLanguage("TUR");
        customer.setGender(Gender.MALE);
        customer.setContactMethod(ContactMethod.EMAIL);
        customer.setCustomerType(CustomerType.PERSONAL);

        dto = new CustomerResponseDto();
        dto.setFirstName("Ali Kaan");
        dto.setLastName("Arbay");
        dto.setDateOfBirth(LocalDate.of(1998, 3, 11));
        dto.setTc("12345678901");
        dto.setPhone("555-1234");
        dto.setEmail("ali.kaan@example.com");
        dto.setPhotoUrl("http://example.com/photo.jpg");
        dto.setOccupation("Software Engineer");
        dto.setLanguage("TUR");
        dto.setGender(Gender.MALE);
        dto.setContactMethod(ContactMethod.EMAIL);
        dto.setCustomerType(CustomerType.PERSONAL);

        CustomerRequestDto requestDto = new CustomerRequestDto();
        requestDto.setFirstName("Lionel");
        requestDto.setLastName("Messi");
        requestDto.setDateOfBirth(LocalDate.of(1987, 6, 24));
        requestDto.setTc("98765432109");
        requestDto.setPhone("555-5678");
        requestDto.setEmail("lionel.messi@example.com");
        requestDto.setPhotoUrl("http://example.com/photo2.jpg");
        requestDto.setOccupation("Footballer");
        requestDto.setLanguage("Spanish");
        requestDto.setGender(Gender.MALE);
        requestDto.setContactMethod(ContactMethod.PHONE);
        requestDto.setCustomerType(CustomerType.CORPORATE);

        AddressRequestDto addressDto = new AddressRequestDto();
        addressDto.setCountry("123 La Ramblada Street");
        addressDto.setCity("Barcelona");
        addressDto.setPostalCode("06000");
        requestDto.setAddress(addressDto);

        Address addressEntity = new Address();
        addressEntity.setCountry("123 La Ramblada Street");
        addressEntity.setCity("Barcelona");
        addressEntity.setPostalCode("06000");
        customer.setAddress(addressEntity);

    }

    @Test
    @DisplayName("getAllCustomer returns mapped DTO list when repository has data")
    void getAllCustomer_returnsList() {
        when(customerRepository.findAll()).thenReturn(Arrays.asList(customer));
        when(customerMapper.toCustomerDtoFromCustomerEntity(customer)).thenReturn(dto);

        List<CustomerResponseDto> result = customerService.getAllCustomer();

        assertThat(result).isNotNull()
                .hasSize(1)
                .containsExactly(dto);
        verify(customerRepository, times(1)).findAll();
        verify(customerMapper, times(1)).toCustomerDtoFromCustomerEntity(customer);
    }

    @Test
    @DisplayName("getAllCustomer throws exception when no customers found")
    void getAllCustomer_noData_throws() {
        when(customerRepository.findAll()).thenReturn(Collections.emptyList());

        assertThrows(CustomerNotFoundException.class, () -> customerService.getAllCustomer());
        verify(customerRepository, times(1)).findAll();
        verifyNoInteractions(customerMapper);
    }

    @Test
    @DisplayName("getCustomerById returns DTO when customer exists")
    void getCustomerById_returnsDto() {
        when(customerRepository.findById(1L)).thenReturn(Optional.of(customer));
        when(customerMapper.toCustomerDtoFromCustomerEntity(customer)).thenReturn(dto);

        CustomerResponseDto result = customerService.getCustomerById(1L);

        assertThat(result).isNotNull();
        assertThat(result.getFirstName()).isEqualTo("Lionel");
        verify(customerRepository, times(1)).findById(1L);
        verify(customerMapper, times(1)).toCustomerDtoFromCustomerEntity(customer);
    }

    @Test
    @DisplayName("getCustomerById throws exception when customer not found")
    void getCustomerById_notFound_throws() {
        when(customerRepository.findById(1L)).thenReturn(Optional.empty());

        assertThrows(CustomerNotFoundException.class, () -> customerService.getCustomerById(1L));
        verify(customerRepository, times(1)).findById(1L);
        verifyNoInteractions(customerMapper);
    }


    @Test
    void testCreateCustomer_ShouldReturn201() {
        // Arrange
        CustomerRequestDto requestDto = new CustomerRequestDto();
        requestDto.setFirstName("Lionel");
        requestDto.setLastName("Messi");
        requestDto.setDateOfBirth(LocalDate.of(1987, 6, 24));
        requestDto.setTc("98765432109");
        requestDto.setPhone("555-5678");
        requestDto.setEmail("lionel.messi@example.com");
        requestDto.setPhotoUrl("http://example.com/photo2.jpg");
        requestDto.setOccupation("Footballer");
        requestDto.setLanguage("Spanish");
        requestDto.setGender(Gender.MALE);
        requestDto.setContactMethod(ContactMethod.PHONE);
        requestDto.setCustomerType(CustomerType.CORPORATE);

        AddressRequestDto addressDto = new AddressRequestDto();
        addressDto.setCountry("123 La Ramblada Street");
        addressDto.setCity("Barcelona");
        addressDto.setPostalCode("34000");
        requestDto.setAddress(addressDto);

        // Act
        ResponseEntity<Void> response = customerController.createCustomer(requestDto);

        // Assert
//        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        verify(customerService, times(1)).createCustomer(requestDto);
    }

    @Test
    public void testGetCustomerByLicenseKey_Success() {
        String licenseKey = "ABC123";
        CustomerResponseDto mockResponse = new CustomerResponseDto();
        mockResponse.setFirstName("John");
        mockResponse.setLastName("Doe");
        mockResponse.setDateOfBirth(LocalDate.of(1990, 1, 1));
        mockResponse.setTc("12345678901");
        mockResponse.setPhone("555-1234");
        mockResponse.setEmail("john.doe@example.com");
        mockResponse.setPhotoUrl("http://example.com/photo.jpg");
        mockResponse.setOccupation("Engineer");
        mockResponse.setLanguage("English");
        mockResponse.setGender(Gender.MALE);
        mockResponse.setContactMethod(ContactMethod.EMAIL);
        mockResponse.setCustomerType(CustomerType.PERSONAL);

        when(customerService.getCustomerByLicenseKey(licenseKey)).thenReturn(mockResponse);

        ResponseEntity<CustomerResponseDto> response = customerController.getCustomerByLicenseKey(licenseKey);

//        assertEquals(200, response.getStatusCodeValue());
//        assertEquals(mockResponse, response.getBody());
        verify(customerService, times(1)).getCustomerByLicenseKey(licenseKey);
    }

    @Test
    public void testGetCustomerByLicenseKey_NotFound() {
        String licenseKey = "INVALID_KEY";

        when(customerService.getCustomerByLicenseKey(licenseKey))
                .thenThrow(new LicenseNotFoundException("License not found: " + licenseKey));

        assertThrows(LicenseNotFoundException.class, () -> {
            customerController.getCustomerByLicenseKey(licenseKey);
        });

        verify(customerService, times(1)).getCustomerByLicenseKey(licenseKey);
    }
}
