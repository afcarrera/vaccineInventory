package com.kruger.vaccineinventory.service;

import com.kruger.vaccineinventory.dto.UserDto;

public interface IUserService {
    UserDto create(UserDto userDto);

    Integer countByUsername(String userName);
}
