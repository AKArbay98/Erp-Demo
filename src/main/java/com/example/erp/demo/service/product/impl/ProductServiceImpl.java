package com.example.erp.demo.service.product.impl;

import com.example.erp.demo.exception.LicenseNotFoundException;
import com.example.erp.demo.exception.ProductNotFoundException;
import com.example.erp.demo.mapper.product.ProductMapperImpl;
import com.example.erp.demo.model.dto.product.ProductRequestDto;
import com.example.erp.demo.model.dto.product.ProductResponseDto;
import com.example.erp.demo.model.entity.product.Product;
import com.example.erp.demo.repository.LicenseRepository;
import com.example.erp.demo.repository.ProductRepository;
import com.example.erp.demo.service.product.ProductService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapperImpl productMapper;
    private final LicenseRepository licenseRepository;

    public ProductServiceImpl(ProductRepository productRepository,
                              ProductMapperImpl productMapper, LicenseRepository licenseRepository) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
        this.licenseRepository = licenseRepository;
    }

    @Override
    public List<ProductResponseDto> getAllProduct() {
        List<Product> products = productRepository.findAll();
        if(products.isEmpty()){
            throw new ProductNotFoundException("Product does not exist.");
        }
        List<ProductResponseDto> productResponseDtoList = new ArrayList<>();
        for(Product product : products){
            ProductResponseDto productResponseDto = productMapper.toProductDtoFromProductEntity(product);
            productResponseDtoList.add(productResponseDto);
        }
        return productResponseDtoList;
    }

    @Override
    public ProductResponseDto getProductById(Long productId) {
        Product product = productRepository.findById(productId).orElse(null);
        if(product == null){
            throw new ProductNotFoundException("Product does not exist.");
        }
        return productMapper.toProductDtoFromProductEntity(product);
    }

    @Override
    public void createProduct(ProductRequestDto productRequestDto) {
        Product product = productMapper.toProductEntityFromProductDto(productRequestDto);
        productRepository.save(product);
    }

    @Override
    public ProductResponseDto getProductByLicenseKey(String licenseKey) {
        return licenseRepository.findByLicenseKey(licenseKey)
                .orElseThrow(() ->
                        new LicenseNotFoundException("License not found: " + licenseKey))
                .getProduct();
    }


}
