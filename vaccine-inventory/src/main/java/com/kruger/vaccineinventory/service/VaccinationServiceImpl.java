package com.kruger.vaccineinventory.service;

import com.kruger.vaccineinventory.dto.VaccinationDto;
import com.kruger.vaccineinventory.model.Vaccination;
import com.kruger.vaccineinventory.repository.IVaccinationRepository;
import com.kruger.vaccineinventory.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VaccinationServiceImpl implements IVaccinationService{

    @Autowired
    private IVaccinationRepository vaccinationRepository;
    @Autowired
    private Mapping mapper;
    /**
     * @param vaccinationDto
     * @return
     */
    @Override
    public VaccinationDto create(VaccinationDto vaccinationDto) {
        Vaccination vaccination = new Vaccination();
        vaccination = (Vaccination) mapper.convertToEntity(vaccinationDto, vaccination);
        VaccinationDto newVaccinationDto = new VaccinationDto();
        newVaccinationDto = (VaccinationDto) mapper.convertToDto(
                vaccinationRepository.save(vaccination), newVaccinationDto);
        return newVaccinationDto;
    }
}
