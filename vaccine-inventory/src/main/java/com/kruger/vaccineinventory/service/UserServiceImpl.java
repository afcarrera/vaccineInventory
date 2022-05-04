package com.kruger.vaccineinventory.service;

import com.kruger.vaccineinventory.dto.UserDto;
import com.kruger.vaccineinventory.model.EndUser;
import com.kruger.vaccineinventory.repository.IUserRepository;
import com.kruger.vaccineinventory.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService{

    @Autowired
    private IUserRepository userRepository;
    @Autowired
    private Mapping mapper;

    /**
     * @param userDto
     * @return
     */
    @Override
    public UserDto create(UserDto userDto) {
        EndUser user = new EndUser();
        user = (EndUser) mapper.convertToEntity(userDto, user);
        UserDto newUserDto = new UserDto();
        newUserDto = (UserDto) mapper.convertToDto(
                userRepository.save(user), newUserDto);
        return newUserDto;
    }

    /**
     * @param userName
     * @return
     */
    @Override
    public Integer countByUsername(String userName) {
        Integer counter = userRepository.countByName(userName);
        return counter;
    }
}
