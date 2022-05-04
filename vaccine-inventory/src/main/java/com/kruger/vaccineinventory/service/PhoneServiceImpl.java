package com.kruger.vaccineinventory.service;

import com.kruger.vaccineinventory.dto.PhoneDto;
import com.kruger.vaccineinventory.model.Phone;
import com.kruger.vaccineinventory.repository.IPhoneRepository;
import com.kruger.vaccineinventory.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhoneServiceImpl implements IPhoneService{

    @Autowired
    private IPhoneRepository phoneRepository;
    @Autowired
    private Mapping mapper;

    /**
     * @param phoneDto
     * @return
     */
    @Override
    public PhoneDto create(PhoneDto phoneDto) {
        Phone phone = new Phone();
        phone = (Phone) mapper.convertToEntity(phoneDto, phone);
        PhoneDto newPhoneDto = new PhoneDto();
        newPhoneDto = (PhoneDto) mapper.convertToDto(
                phoneRepository.save(phone), newPhoneDto);
        return newPhoneDto;
    }
}
