package com.example.erp.demo.service.product;

import com.example.erp.demo.model.dto.product.ProductRequestDto;
import com.example.erp.demo.model.dto.product.ProductResponseDto;

import java.util.List;

public interface ProductService {

    List<ProductResponseDto> getAllProduct();

    ProductResponseDto getProductById(Long productId);

    void createProduct(ProductRequestDto productRequestDto);

    ProductResponseDto getProductByLicenseKey(String licenseKey);
}
