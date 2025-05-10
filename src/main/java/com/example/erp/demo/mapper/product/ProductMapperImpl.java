package com.example.erp.demo.mapper.product;

import com.example.erp.demo.model.dto.product.ProductRequestDto;
import com.example.erp.demo.model.dto.product.ProductResponseDto;
import com.example.erp.demo.model.entity.product.Product;

public class ProductMapperImpl implements ProductMapper{
    @Override
    public ProductResponseDto toProductDtoFromProductEntity(Product product) {
        return null;
    }

    @Override
    public Product toProductEntityFromProductDto(ProductRequestDto productRequestDto) {
        return null;
    }
}
