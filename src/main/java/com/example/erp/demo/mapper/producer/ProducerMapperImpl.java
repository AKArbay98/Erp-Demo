package com.example.erp.demo.mapper.producer;

import com.example.erp.demo.model.dto.producer.ProducerRequestDto;
import com.example.erp.demo.model.dto.producer.ProducerResponseDto;
import com.example.erp.demo.model.entity.producer.Producer;
import org.springframework.stereotype.Component;


@Component
public class ProducerMapperImpl implements ProducerMapper{

    @Override
    public ProducerResponseDto toProducerDtoFromProducerEntity(Producer producer){
        ProducerResponseDto producerResponseDto = new ProducerResponseDto();
        producerResponseDto.setName(producer.getName());
        producerResponseDto.setDescription(producer.getDescription());
        producerResponseDto.setContactEmail(producer.getContactEmail());
        producerResponseDto.setContactPhone(producer.getContactPhone());
        producerResponseDto.setWebsiteUrl(producer.getWebsiteUrl());

        // relation lara da bak

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

        // relation lara da bak

        return producer;
    }
}
