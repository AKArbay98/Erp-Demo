package com.example.erp.demo.mapper.producer;

import com.example.erp.demo.model.dto.producer.ProducerRequestDto;
import com.example.erp.demo.model.dto.producer.ProducerResponseDto;
import com.example.erp.demo.model.entity.producer.Producer;

public interface ProducerMapper {

    ProducerResponseDto toProducerDtoFromProducerEntity(Producer producer);

    Producer toProducerEntityFromProducerDto(ProducerRequestDto producerRequestDto);
}
