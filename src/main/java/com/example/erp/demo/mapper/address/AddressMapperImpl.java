package com.example.erp.demo.mapper.address;

import com.example.erp.demo.model.dto.address.AddressRequestDto;
import com.example.erp.demo.model.dto.address.AddressResponseDto;
import com.example.erp.demo.model.entity.address.Address;
import org.springframework.stereotype.Component;


@Component
public class AddressMapperImpl implements AddressMapper{

    @Override
    public AddressResponseDto toAddressDtoFromAddressEntity(Address address){
        AddressResponseDto addressResponseDto = new AddressResponseDto();
        addressResponseDto.setCountry(address.getCountry());
        addressResponseDto.setCity(address.getCity());
        addressResponseDto.setStateProvince(address.getStateProvince());
        addressResponseDto.setDistrict(address.getDistrict());
        addressResponseDto.setStreetAddress(address.getStreetAddress());
        addressResponseDto.setAddressLineTwo(address.getAddressLineTwo());
        addressResponseDto.setPostalCode(address.getPostalCode());
        addressResponseDto.setIsVerified(address.getIsVerified());

        // relation lara da bak

        return addressResponseDto;
    }


    @Override
    public Address toAddressEntityFromAddressDto(AddressRequestDto addressRequestDto) {
        if(addressRequestDto == null){
            return null;
        }
        Address address = new Address();
        address.setCountry(addressRequestDto.getCountry());
        address.setCity(addressRequestDto.getCity());
        address.setStateProvince(addressRequestDto.getStateProvince());
        address.setDistrict(addressRequestDto.getDistrict());
        address.setStreetAddress(addressRequestDto.getStreetAddress());
        address.setAddressLineTwo(addressRequestDto.getAddressLineTwo());
        address.setPostalCode(addressRequestDto.getPostalCode());
        address.setIsVerified(addressRequestDto.getIsVerified());

        // relation lara da bak

        return address;
    }

}
