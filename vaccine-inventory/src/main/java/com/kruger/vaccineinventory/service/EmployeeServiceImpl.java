package com.kruger.vaccineinventory.service;

import com.kruger.vaccineinventory.dto.EmployeeDto;
import com.kruger.vaccineinventory.model.Employee;
import com.kruger.vaccineinventory.repository.IEmployeeRepository;
import com.kruger.vaccineinventory.util.Mapping;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements IEmployeeService{
    @Autowired
    private IEmployeeRepository employeeRepository;

    @Autowired
    private Mapping mapper;

    /**
     * @param employeeDto
     * @return newEmployee
     */
    @Override
    public EmployeeDto create(EmployeeDto employeeDto) {
        Employee employee = new Employee();
        employee = (Employee) mapper.convertToEntity(employeeDto, employee);
        EmployeeDto newEmployeeDto = new EmployeeDto();
        newEmployeeDto = (EmployeeDto) mapper.convertToDto(
                employeeRepository.save(employee), newEmployeeDto);
        return newEmployeeDto;
    }

    /**
     * @param employeeDto
     * @return updatedEmployee
     */
    @Override
    public EmployeeDto update(EmployeeDto employeeDto) {
        Employee employee = new Employee();
        employee = (Employee) mapper.convertToEntity(employeeDto, employee);
        EmployeeDto updatedEmployeeDto = new EmployeeDto();
        updatedEmployeeDto = (EmployeeDto) mapper.convertToDto(
                employeeRepository.save(employee), updatedEmployeeDto);
        return updatedEmployeeDto;
    }

    /**
     * @param id
     * @return employeeById
     */
    @Override
    public EmployeeDto findById(Integer id) {
        Employee employeeById = findEmployeeById(id);
        if (employeeById == null){
            return null;
        }
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto = (EmployeeDto) mapper.convertToDto(
                employeeById, employeeDto);
        return employeeDto;
    }

    /**
     * @return allEmployees
     */
    @Override
    public List<EmployeeDto> findAll() {
        List<Employee> allEmployees = employeeRepository.findAll();
        List<EmployeeDto>  employeeDtos  = new ArrayList<EmployeeDto>();
        EmployeeDto employeeDto;
        for (Employee employee : allEmployees){
            employeeDto = new EmployeeDto();
            employeeDto = (EmployeeDto) mapper.convertToDto(
                    employee, employeeDto);
            employeeDtos.add(employeeDto);
        }
        return employeeDtos;
    }

    /**
     * @param id
     */
    @Override
    public void delete(Integer id) {
        employeeRepository.deleteById(id);
    }

    /**
     * @param identification
     * @return
     */
    @Override
    public Integer countByIdentification(String identification) {
        Integer counter = employeeRepository.countByIdentification(identification);
        return counter;
    }

    /**
     * @param state
     * @return
     */
    @Override
    public Collection<EmployeeDto> findByState(String state) {
        Collection<Employee> findByState = employeeRepository.findByStatus(state);
        return getVaccinationDtos(findByState);
    }

    /**
     * @param vaccinationType
     * @return
     */
    @Override
    public Collection<EmployeeDto> findByVaccinationType(String vaccinationType) {
        Collection<Employee> findByVaccinationType = employeeRepository.findByVaccineType(vaccinationType);
        return getVaccinationDtos(findByVaccinationType);
    }

    /**
     * @param startDate
     * @param endDate
     * @return
     */
    @Override
    public Collection<EmployeeDto> findByDate(Date startDate, Date endDate) {
        Collection<Employee> findByDate = employeeRepository.findByDate(startDate, endDate);
        return getVaccinationDtos(findByDate);
    }

    @NotNull
    private Collection<EmployeeDto> getVaccinationDtos(Collection<Employee> Employees) {
        Collection<EmployeeDto> employeeDtos  = new ArrayList<>();
        EmployeeDto employeeDto;
        for (Employee vaccination : Employees){
            employeeDto = new EmployeeDto();
            employeeDto = (EmployeeDto) mapper.convertToDto(
                    vaccination, employeeDto);
            EmployeeDto filteredEmployeeDto = new EmployeeDto();
            filteredEmployeeDto.setEmplId(employeeDto.getEmplId());
            filteredEmployeeDto.setUserId(employeeDto.getUserId());
            filteredEmployeeDto.setEmplFullName(employeeDto.getEmplFullName());
            employeeDtos.add(filteredEmployeeDto);
        }
        return employeeDtos;
    }

    private Employee findEmployeeById(Integer id){
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        Employee employeeById = employeeOptional.orElse(null);
        return employeeById;
    }
}
