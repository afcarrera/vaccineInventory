package com.kruger.vaccineinventory.controller;

import com.kruger.vaccineinventory.dto.PhoneDto;
import com.kruger.vaccineinventory.dto.PhoneTypeDto;
import com.kruger.vaccineinventory.exception.RequiredException;
import com.kruger.vaccineinventory.exception.ValidationException;
import com.kruger.vaccineinventory.service.PhoneServiceImpl;
import com.kruger.vaccineinventory.util.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class PhoneController {
    @Autowired
    private PhoneServiceImpl phoneServiceImpl;
    @Autowired
    private PhoneTypeController phonetypeController;

    public PhoneDto create(PhoneDto phoneDto) throws ValidationException, RequiredException {
        String requiredMessage = validateRequired(phoneDto);
        if (requiredMessage != null){
            throw new RequiredException(requiredMessage);
        }
        if (!validatePhoneType(phoneDto)){
            throw new ValidationException(Messages.Errors.INVALID_PHONE_TYPE.toString());
        }
        return phoneServiceImpl.create(phoneDto);
    }

    private boolean validatePhoneType(PhoneDto phoneDto){
        List<PhoneTypeDto> phoneTypeDtoList = phonetypeController.findAll();
        for (PhoneTypeDto phoneTypeDto: phoneTypeDtoList){
            if (phoneTypeDto.getPhtyId().equals(phoneDto.getPhtyId())){
                return true;
            }
        }
        return false;
    }

    private String validateRequired(PhoneDto phoneDto){
        if (phoneDto.getPhonNumber() == null){
            return Messages.Required.PHONE_NUMBER.toString();
        }
        if (phoneDto.getPhtyId() == null){
            return Messages.Required.PHONE_TYPE.toString();
        }
        return null;
    }
}
