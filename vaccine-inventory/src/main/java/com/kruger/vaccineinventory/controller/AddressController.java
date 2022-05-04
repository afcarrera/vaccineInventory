package com.kruger.vaccineinventory.controller;

import com.kruger.vaccineinventory.dto.AddressDto;
import com.kruger.vaccineinventory.exception.RequiredException;
import com.kruger.vaccineinventory.service.AddressServiceImpl;
import com.kruger.vaccineinventory.util.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class AddressController {
    @Autowired
    private AddressServiceImpl addressServiceImpl;

    public AddressDto create(AddressDto addressDto){
        String requiredMessage = validateRequired(addressDto);
        if (requiredMessage != null){
            throw new RequiredException(requiredMessage);
        }
        return addressServiceImpl.create(addressDto);
    }

    private String validateRequired(AddressDto addressDto){
        if (addressDto.getAddrDescription() == null){
            return Messages.Required.ADDRESS_DESCRIPTION.toString();
        }
        return null;
    }

}
