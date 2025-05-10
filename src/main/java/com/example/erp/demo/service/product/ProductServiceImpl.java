package com.example.erp.demo.service.product;

import com.example.erp.demo.mapper.product.ProductMapperImpl;
import com.example.erp.demo.model.dto.product.ProductResponseDto;
import com.example.erp.demo.model.entity.product.Product;
import com.example.erp.demo.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapperImpl productMapper;

    public ProductServiceImpl(ProductRepository productRepository,
                              ProductMapperImpl productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    public List<ProductResponseDto> getAllProduct() {
        List<Product> productList = productRepository.findAll();
        if(productList == null || productList.isEmpty()){
            throw new IllegalArgumentException("Customer does not exist.");
        }
        List<ProductResponseDto> productResponseDtoList = new ArrayList<>();
        for(Product product : productList){
            ProductResponseDto productResponseDto = productMapper.toProductDtoFromProductEntity(product);
            productResponseDtoList.add(productResponseDto);
        }
        return productResponseDtoList;
    }

    @Override
    public ProductResponseDto getProductById(Long productId) {
        Product product = productRepository.findById(productId).orElse(null);
        if(product == null){
            throw new IllegalArgumentException("Product does not exist.");
        }
        return productMapper.toProductDtoFromProductEntity(product);
    }


}
