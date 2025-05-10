package com.example.erp.demo.controller.license;

import com.example.erp.demo.service.license.LicenseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/license")
@RequiredArgsConstructor
public class LicenseController {

    private final LicenseService licenseService;

    @Operation(summary = "Check if a license key is valid")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Validity returned"),
            @ApiResponse(responseCode = "404", description = "License not found")
    })
    @GetMapping("/{licenseKey}/valid")
    public boolean isValidLicenseKey(@PathVariable String licenseKey){
        return licenseService.isValidLicenseKey(licenseKey);
    }

//    @Operation(summary = "Get customer by license key")
//
//    @Operation(summary = "Get product by license key")
//
//    @Operation(summary = "Generate a new license for a customer and product")


}
