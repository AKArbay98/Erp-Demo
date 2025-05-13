package com.example.erp.demo.controller.license;

import com.example.erp.demo.service.license.LicenseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/license")
public class LicenseController {

    private final LicenseService licenseService;

    public LicenseController(LicenseService licenseService) {
        this.licenseService = licenseService;
    }

    @Operation(summary = "Check if a license key is valid")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Validity returned"),
            @ApiResponse(responseCode = "404", description = "License not found")
    })
    @GetMapping("/{licenseKey}/valid")
    public boolean isValidLicenseKey(@PathVariable String licenseKey){
        return licenseService.isValidLicenseKey(licenseKey);
    }


    @Operation(summary = "Generate a new license for a customer and product")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "License created"),
            @ApiResponse(responseCode = "400", description = "Invalid request data")
    })
    @PostMapping
    public String createLicenseKey(Long customerId, Long productId){
        return licenseService.createLicenseKey(customerId,productId);
    }


}
