package com.example.erp.demo.mapper.address;

import com.example.erp.demo.model.dto.address.AddressRequestDto;
import com.example.erp.demo.model.dto.address.AddressResponseDto;
import com.example.erp.demo.model.entity.address.Address;

public interface AddressMapper {

    AddressResponseDto toAddressDtoFromAddressEntity(Address address);

    Address toAddressEntityFromAddressDto(AddressRequestDto addressRequestDto);
}
