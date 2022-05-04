package com.kruger.vaccineinventory.service;

import com.kruger.vaccineinventory.dto.PhoneTypeDto;

import java.util.List;

public interface IPhoneTypeService {
    List<PhoneTypeDto> findAll();
}
