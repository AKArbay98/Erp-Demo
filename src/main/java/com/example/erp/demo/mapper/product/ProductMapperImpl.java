package com.example.erp.demo.mapper.product;

import com.example.erp.demo.model.dto.product.ProductRequestDto;
import com.example.erp.demo.model.dto.product.ProductResponseDto;
import com.example.erp.demo.model.entity.product.Product;
import org.springframework.stereotype.Component;


@Component
public class ProductMapperImpl implements ProductMapper{

    @Override
    public ProductResponseDto toProductDtoFromProductEntity(Product product) {
        ProductResponseDto productResponseDto = new ProductResponseDto();
        productResponseDto.setName(product.getName());
        productResponseDto.setProductVersion(product.getProductVersion());
        productResponseDto.setDescription(product.getDescription());
        productResponseDto.setSku(product.getSku());
        productResponseDto.setBasePrice(product.getBasePrice());
        productResponseDto.setDiscountedPrice(product.getDiscountedPrice());
        productResponseDto.setReleaseDate(product.getReleaseDate());
        productResponseDto.setSupportExpiration(product.getSupportExpiration());
        productResponseDto.setCustomerSatisfaction(product.getCustomerSatisfaction());
        productResponseDto.setComment(product.getComment());

        // relation lara da bak

        return productResponseDto;
    }

    @Override
    public Product toProductEntityFromProductDto(ProductRequestDto productRequestDto) {
        if(productRequestDto == null){
            return null;
        }
        Product product = new Product();
        product.setName(productRequestDto.getName());
        product.setProductVersion(productRequestDto.getProductVersion());
        product.setDescription(productRequestDto.getDescription());
        product.setSku(productRequestDto.getSku());
        product.setBasePrice(productRequestDto.getBasePrice());
        product.setDiscountedPrice(productRequestDto.getDiscountedPrice());
        product.setReleaseDate(productRequestDto.getReleaseDate());
        product.setSupportExpiration(productRequestDto.getSupportExpiration());
        product.setCustomerSatisfaction(productRequestDto.getCustomerSatisfaction());
        product.setComment(productRequestDto.getComment());

        // relation lara da bak

        return product;
    }
}
