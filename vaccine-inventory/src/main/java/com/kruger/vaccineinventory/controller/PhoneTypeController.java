package com.kruger.vaccineinventory.controller;

import com.kruger.vaccineinventory.dto.PhoneTypeDto;
import com.kruger.vaccineinventory.service.PhoneTypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class PhoneTypeController {
    @Autowired
    private PhoneTypeServiceImpl phoneTypeServiceImpl;

    public List<PhoneTypeDto> findAll(){
        return phoneTypeServiceImpl.findAll();
    }
}
