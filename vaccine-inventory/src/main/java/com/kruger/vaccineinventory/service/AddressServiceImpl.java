package com.kruger.vaccineinventory.service;

import com.kruger.vaccineinventory.dto.AddressDto;
import com.kruger.vaccineinventory.model.Address;
import com.kruger.vaccineinventory.repository.IAddressRepository;
import com.kruger.vaccineinventory.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements IAddressService{

    @Autowired
    private IAddressRepository addressRepository;
    @Autowired
    private Mapping mapper;
    /**
     * @param addressDto
     * @return
     */
    @Override
    public AddressDto create(AddressDto addressDto) {
        Address address = new Address();
        address = (Address) mapper.convertToEntity(addressDto, address);
        AddressDto newAddressDto = new AddressDto();
        newAddressDto = (AddressDto) mapper.convertToDto(
                addressRepository.save(address), newAddressDto);
        return newAddressDto;
    }
}
