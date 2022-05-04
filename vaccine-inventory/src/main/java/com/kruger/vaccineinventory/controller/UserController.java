package com.kruger.vaccineinventory.controller;

import com.kruger.vaccineinventory.dto.UserDto;
import com.kruger.vaccineinventory.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    @Autowired
    private UserServiceImpl userServiceImpl;

    public UserDto create(UserDto userDto){
        int counter = userServiceImpl.countByUsername(userDto.getUserName());
        userDto.setUserName(userDto.getUserName()+counter);
        return userServiceImpl.create(userDto);
    }
}
