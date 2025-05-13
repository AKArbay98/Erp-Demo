package com.example.erp.demo.controller.customer;

import com.example.erp.demo.model.dto.customer.CustomerRequestDto;
import com.example.erp.demo.model.dto.customer.CustomerResponseDto;
import com.example.erp.demo.service.customer.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Operation(summary = "Retrieve all customers")
    @ApiResponse(responseCode = "200", description = "List of customers returned",
            content = @Content(mediaType = "application/json",
                    schema = @Schema(implementation = CustomerResponseDto.class)))
    @GetMapping
    public ResponseEntity<List<CustomerResponseDto>> getAllCustomer(){
        return ResponseEntity.ok(customerService.getAllCustomer());
    }

    @Operation(summary = "Retrieve a customer by ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Customer found",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CustomerResponseDto.class))),
            @ApiResponse(responseCode = "404", description = "Customer not found",
                    content = @Content)
    })
    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerResponseDto> getCustomer(@PathVariable Long customerId){
        return ResponseEntity.ok(customerService.getCustomerById(customerId));
    }

    @Operation(summary = "Create a new customer")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Customer created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid request data",
                    content = @Content)
    })
    @PostMapping
    public ResponseEntity<Void> createCustomer(@RequestBody CustomerRequestDto customerRequestDto){
        customerService.createCustomer(customerRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Operation(summary = "Get customer by license key")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Customer details returned"),
            @ApiResponse(responseCode = "404", description = "Customer not found")
    })
    @GetMapping("/license/{licenseKey}")
    public ResponseEntity<CustomerResponseDto> getCustomerByLicenseKey(@PathVariable String licenseKey){
        return ResponseEntity.ok(customerService.getCustomerByLicenseKey(licenseKey));
    }

}
