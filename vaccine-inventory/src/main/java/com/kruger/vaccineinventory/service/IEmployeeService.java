package com.kruger.vaccineinventory.service;

import com.kruger.vaccineinventory.dto.EmployeeDto;

import java.sql.Date;
import java.util.Collection;
import java.util.List;

public interface IEmployeeService {
    EmployeeDto create(EmployeeDto employee);

    EmployeeDto update(EmployeeDto employee);

    EmployeeDto findById(Integer id);

    List<EmployeeDto> findAll();

    void delete(Integer id);

    Integer countByIdentification(String identification);

    Collection<EmployeeDto> findByState(String state);

    Collection<EmployeeDto> findByVaccinationType(String vaccinationType);

    Collection<EmployeeDto> findByDate(Date startDate, Date endDate);
}
