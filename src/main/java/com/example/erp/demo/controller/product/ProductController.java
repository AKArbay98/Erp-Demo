package com.example.erp.demo.controller.product;

import com.example.erp.demo.model.dto.product.ProductRequestDto;
import com.example.erp.demo.model.dto.product.ProductResponseDto;
import com.example.erp.demo.service.product.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @Operation(summary = "Retrieve all products")
    @ApiResponse(responseCode = "200", description = "Products retrieved successfully")
    @GetMapping
    public ResponseEntity<List<ProductResponseDto>> getAllProduct(){
        return ResponseEntity.ok(productService.getAllProduct());
    }

    @Operation(summary = "Retrieve a product by its ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Product found"),
            @ApiResponse(responseCode = "404", description = "Product not found")
    })
    @GetMapping("/id/{productId}")
    public ResponseEntity<ProductResponseDto> getProduct(@PathVariable Long productId){
        return ResponseEntity.ok(productService.getProductById(productId));
    }

    @Operation(summary = "Create a new product")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Product created"),
            @ApiResponse(responseCode = "400", description = "Invalid request data")
    })
    @PostMapping
    public ResponseEntity<Void> createProduct(@RequestBody ProductRequestDto productRequestDto){
        productService.createProduct(productRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Operation(summary = "Get product by license key")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "Product found by License Key"),
            @ApiResponse(responseCode = "400", description = "Product not found")
    })
    @GetMapping("/license/{licenseKey}")
    public ResponseEntity<ProductResponseDto> getProductByLicenseKey(@PathVariable String licenseKey){
        return ResponseEntity.ok(productService.getProductByLicenseKey(licenseKey));
    }

}
