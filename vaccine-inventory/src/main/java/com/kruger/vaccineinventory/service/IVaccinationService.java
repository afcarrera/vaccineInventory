package com.kruger.vaccineinventory.service;

import com.kruger.vaccineinventory.dto.VaccinationDto;

public interface IVaccinationService {
    VaccinationDto create(VaccinationDto vaccinationDto);
}
