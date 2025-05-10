package com.example.erp.demo.mapper.product;

import com.example.erp.demo.model.dto.product.ProductResponseDto;
import com.example.erp.demo.model.entity.product.Product;

public interface ProductMapper {

    ProductResponseDto toProductDtoFromProductEntity(Product product);
}
