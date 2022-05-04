package com.kruger.vaccineinventory.controller;

import com.kruger.vaccineinventory.dto.VaccinationDto;
import com.kruger.vaccineinventory.service.VaccinationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class VaccinationController {
    @Autowired
    private VaccinationServiceImpl vaccinationServiceImpl;

    public VaccinationDto create(VaccinationDto vaccinationDto)  {
        return vaccinationServiceImpl.create(vaccinationDto);
    }
}
