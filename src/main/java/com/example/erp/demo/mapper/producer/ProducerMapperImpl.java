package com.example.erp.demo.mapper.producer;

import com.example.erp.demo.mapper.address.AddressMapper;
import com.example.erp.demo.mapper.product.ProductMapper;
import com.example.erp.demo.model.dto.producer.ProducerRequestDto;
import com.example.erp.demo.model.dto.producer.ProducerResponseDto;
import com.example.erp.demo.model.dto.product.ProductResponseDto;
import com.example.erp.demo.model.entity.producer.Producer;
import com.example.erp.demo.model.entity.product.Product;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class ProducerMapperImpl implements ProducerMapper{

    private final AddressMapper addressMapper;
    private final ProductMapper productMapper;

    public ProducerMapperImpl(@Lazy AddressMapper addressMapper,
                              @Lazy ProductMapper productMapper) {
        this.addressMapper = addressMapper;
        this.productMapper = productMapper;
    }

    @Override
    public ProducerResponseDto toProducerDtoFromProducerEntity(Producer producer){
        ProducerResponseDto producerResponseDto = new ProducerResponseDto();
        producerResponseDto.setName(producer.getName());
        producerResponseDto.setDescription(producer.getDescription());
        producerResponseDto.setContactEmail(producer.getContactEmail());
        producerResponseDto.setContactPhone(producer.getContactPhone());
        producerResponseDto.setWebsiteUrl(producer.getWebsiteUrl());
        List<ProductResponseDto> productDtos = Optional.ofNullable(producer.getProducts())
                .orElse(Collections.emptyList())
                .stream()
                .map(productMapper::toProductDtoFromProductEntity)
                .collect(Collectors.toList());
        producerResponseDto.setProducts(productDtos);
        if (producer.getAddress() != null) {
            producerResponseDto.setAddress(addressMapper
                    .toAddressDtoFromAddressEntity(producer.getAddress()));
        }
        return producerResponseDto;
    }

    @Override
    public Producer toProducerEntityFromProducerDto(ProducerRequestDto producerRequestDto) {
        if(producerRequestDto == null){
            return null;
        }
        Producer producer = new Producer();
        producer.setName(producerRequestDto.getName());
        producer.setDescription(producerRequestDto.getDescription());
        producer.setContactEmail(producerRequestDto.getContactEmail());
        producer.setContactPhone(producerRequestDto.getContactPhone());
        producer.setWebsiteUrl(producerRequestDto.getWebsiteUrl());
        if (producerRequestDto.getAddress() != null) {
            producer.setAddress(
                    addressMapper.toAddressEntityFromAddressDto(producerRequestDto.getAddress())
            );
        }
        List<Product> products = Optional.ofNullable(producerRequestDto.getProducts())
                .orElse(Collections.emptyList())
                .stream()
                .map(productMapper::toProductEntityFromProductDto)
                .collect(Collectors.toList());
        producer.setProducts(products);
        return producer;
    }
}
