package com.kruger.vaccineinventory.util;

import com.kruger.vaccineinventory.dto._DTOEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class Mapping {

    public _DTOEntity convertToDto(Object obj, _DTOEntity dto) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(obj, dto.getClass());
    }

    public Object convertToEntity(_DTOEntity dto, Object obj) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(dto, obj.getClass());
    }
}
