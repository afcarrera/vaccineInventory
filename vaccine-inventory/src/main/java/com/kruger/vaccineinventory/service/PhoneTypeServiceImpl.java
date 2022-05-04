package com.kruger.vaccineinventory.service;

import com.kruger.vaccineinventory.dto.PhoneTypeDto;
import com.kruger.vaccineinventory.model.PhoneType;
import com.kruger.vaccineinventory.repository.IPhoneTypeRepository;
import com.kruger.vaccineinventory.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class PhoneTypeServiceImpl implements IPhoneTypeService {

    @Autowired
    private IPhoneTypeRepository phoneTypeRepository;
    @Autowired
    private Mapping mapper;
    /**
     * @return
     */
    @Override
    public List<PhoneTypeDto> findAll() {
        List<PhoneType> allPhoneTypes = phoneTypeRepository.findAll();
        List<PhoneTypeDto>  phoneTypeDtos  = new ArrayList<>();
        PhoneTypeDto phoneTypeDto;
        for (PhoneType phoneType : allPhoneTypes){
            phoneTypeDto = new PhoneTypeDto();
            phoneTypeDto = (PhoneTypeDto) mapper.convertToDto(
                    phoneType, phoneTypeDto);
            phoneTypeDtos.add(phoneTypeDto);
        }
        return phoneTypeDtos;
    }
}
