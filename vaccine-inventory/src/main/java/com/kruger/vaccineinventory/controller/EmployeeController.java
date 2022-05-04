package com.kruger.vaccineinventory.controller;

import com.kruger.vaccineinventory.dto.AddressDto;
import com.kruger.vaccineinventory.dto.EmployeeDto;
import com.kruger.vaccineinventory.dto.PhoneDto;
import com.kruger.vaccineinventory.dto.UserDto;
import com.kruger.vaccineinventory.dto.VaccinationDto;
import com.kruger.vaccineinventory.exception.FormatException;
import com.kruger.vaccineinventory.exception.RequiredException;
import com.kruger.vaccineinventory.exception.ResourceNotFoundException;
import com.kruger.vaccineinventory.exception.ValidationException;
import com.kruger.vaccineinventory.service.EmployeeServiceImpl;
import com.kruger.vaccineinventory.util.Constants;
import com.kruger.vaccineinventory.util.EmployeeValidator;
import com.kruger.vaccineinventory.util.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.nio.charset.StandardCharsets;
import java.security.Principal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController extends ResponseEntityExceptionHandler {
    @Autowired
    private EmployeeServiceImpl employeeServiceImpl;
    @Autowired
    private EmployeeValidator employeeValidator;
    @Autowired
    private UserController userController;
    @Autowired
    private PhoneController phoneController;
    @Autowired
    private AddressController addressController;
    @Autowired
    private VaccinationController vaccinationController;

    @GetMapping
    public ResponseEntity<List<EmployeeDto>> findAll(Principal principal){
        System.out.println(principal);
        List<EmployeeDto> employeeDtoList = employeeServiceImpl.findAll();
        return new ResponseEntity<>(employeeDtoList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<EmployeeDto> create(@RequestBody EmployeeDto employee, Principal principal) throws ValidationException {
        System.out.println(principal);
        String requiredMessage = validateRequired(employee);
        if (requiredMessage != null){
            throw new RequiredException(requiredMessage);
        }
        String firstName =  employeeValidator.validateLetters(employee.getEmplFirstName());
        if (firstName == null) {
            throw new ValidationException(Messages.Errors.INVALID_NAME.toString());
        }
        employee.setEmplFirstName(firstName);
        String secondName = employeeValidator.validateLetters(employee.getEmplSecondName());
        if (secondName == null) {
            throw new ValidationException(Messages.Errors.INVALID_SECOND_NAME.toString());
        }
        employee.setEmplSecondName(secondName);
        String firstSurname = employeeValidator.validateLetters(employee.getEmplFirstSurname());
        if (firstSurname == null) {
            throw new ValidationException(Messages.Errors.INVALID_SURNAME.toString());
        }
        employee.setEmplFirstSurname(firstSurname);
        String secondSurname = employeeValidator.validateLetters(employee.getEmplSecondSurname());
        if (secondSurname == null) {
            throw new ValidationException(Messages.Errors.INVALID_SECOND_SURNAME.toString());
        }
        employee.setEmplSecondSurname(secondSurname);
        if (!employeeValidator.validateEmail(employee.getEmplEmail())) {
            throw new ValidationException(Messages.Errors.INVALID_EMAIL.toString());
        }
        if (!employeeValidator.validateIdentification(employee.getEmplIdentification())) {
            throw new ValidationException(Messages.Errors.INVALID_IDENTIFICATION.toString());
        }
        if (employeeServiceImpl.countByIdentification(employee.getEmplIdentification()) != 0){
            throw new ValidationException(Messages.Errors.DUPLICATED_IDENTIFICATION.toString());
        }
        employee.setEmplFullName(employeeValidator.setFullName(
                employee.getEmplFirstName(),
                employee.getEmplSecondName(),
                employee.getEmplFirstSurname(),
                employee.getEmplSecondSurname()
        ));
        UserDto userDto = new UserDto();
        userDto.setUserName(employeeValidator.setUsername(
                employee.getEmplFirstName(),
                employee.getEmplSecondName(),
                employee.getEmplFirstSurname()));
        userDto.setUserPassword(
                org.apache.commons.codec.digest.DigestUtils.sha256Hex(employee.getEmplIdentification()));
        userDto.setRoleId(Constants.EMPLOYEE_ROLE);
        userDto.setUserModificationDate(new Date(System.currentTimeMillis()));
        userDto = userController.create(userDto);
        employee.setUserId(userDto.getUserId());
        validateVaccinationStatus(employee);
        EmployeeDto newEmployee = employeeServiceImpl.create(employee);
        userDto.setUserPassword(null);
        newEmployee.setUserDto(userDto);
        return new ResponseEntity<>(newEmployee, HttpStatus.OK);
    }

    @PatchMapping("/{employeeId}")
    public ResponseEntity<EmployeeDto> update(@PathVariable("employeeId") Integer employeeId,
                                              @RequestBody EmployeeDto employee) throws ValidationException {
        EmployeeDto employeeById = employeeServiceImpl.findById(employeeId);
        if(employeeById == null) {
            throw new ResourceNotFoundException(Messages.NotFound.NOT_FOUND_UPDATE.toString());
        }
        employee.setEmplId(employeeId);
        if (employee.getVastId() == null){
            employee.setVastId(employeeById.getVastId());
        }
        validateVaccinationStatus(employee);
        if (employee.getEmplEmail() != null){
            employeeById.setEmplEmail(employee.getEmplEmail());
        }
        if (employee.getEmplBirthdayDate() != null){
            employeeById.setEmplBirthdayDate(employee.getEmplBirthdayDate());
        }
        if (employee.getVastId() != null){
            employeeById.setVastId(employee.getVastId());
        }
        EmployeeDto updatedEmployee = employeeServiceImpl.update(employeeById);
        return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<EmployeeDto> findById(@PathVariable("employeeId") Integer employeeId){
        EmployeeDto employeeById = employeeServiceImpl.findById(employeeId);
        if(employeeById == null) {
            throw new ResourceNotFoundException(Messages.NotFound.NOT_FOUND_GET_BY_ID.toString());
        }
        return new ResponseEntity<>(employeeById, HttpStatus.OK);
    }

    @DeleteMapping("/{employeeId}")
    public ResponseEntity<Object> delete(@PathVariable("employeeId") Integer employeeId){
        EmployeeDto employeeById = employeeServiceImpl.findById(employeeId);
        if(employeeById == null) {
            throw new ResourceNotFoundException(Messages.NotFound.NOT_FOUND_DELETE.toString());
        }
        employeeServiceImpl.delete(employeeId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/{employeeId}/phone")
    public PhoneDto create(@PathVariable("employeeId") Integer employeeId,
                           @RequestBody PhoneDto phoneDto) throws ValidationException, RequiredException{
        EmployeeDto employeeById = employeeServiceImpl.findById(employeeId);
        if(employeeById == null) {
            throw new ResourceNotFoundException(Messages.NotFound.NOT_FOUND_UPDATE.toString());
        }
        phoneDto.setEmplId(employeeId);
        phoneDto = phoneController.create(phoneDto);
        return phoneDto;
    }

    @PostMapping("/{employeeId}/address")
    public AddressDto create(@PathVariable("employeeId") Integer employeeId,
                             @RequestBody AddressDto addressDto) throws RequiredException{
        EmployeeDto employeeById = employeeServiceImpl.findById(employeeId);
        if(employeeById == null) {
            throw new ResourceNotFoundException(Messages.NotFound.NOT_FOUND_UPDATE.toString());
        }
        addressDto.setEmplId(employeeId);
        addressDto = addressController.create(addressDto);
        return addressDto;
    }

    @GetMapping("/vaccination-by-status/{status}")
    public Collection<EmployeeDto> findByVaccinationStatus(@PathVariable("status")  String status){
        return employeeServiceImpl.findByState(status);
    }

    @GetMapping("/vaccination-by-type/{type}")
    public Collection<EmployeeDto> findByVaccinationType(@PathVariable("type")  String type){
        return employeeServiceImpl.findByVaccinationType(type);
    }

    @GetMapping("/vaccination-by-date")
    public Collection<EmployeeDto> findByVaccinationDate(@RequestParam("startDate")  String startDate,
                                                            @RequestParam("endDate")  String endDate) {
        try {
            String startDateDecoded = java.net.URLDecoder.decode(startDate, StandardCharsets.UTF_8);
            String endDateDecoded = java.net.URLDecoder.decode(endDate, StandardCharsets.UTF_8);
            return employeeServiceImpl.findByDate(Date.valueOf(startDateDecoded),Date.valueOf(endDateDecoded));
        }catch (IllegalArgumentException illegalArgumentException){
            throw new FormatException(Messages.Errors.INVALID_DATE_FORMAT.toString());
        }
    }

    private String validateRequired(EmployeeDto employeeDto){
        if (employeeDto.getEmplIdentification() == null){
            return Messages.Required.EMPLOYEE_IDENTIFICATION.toString();
        }
        if (employeeDto.getEmplFirstName() == null){
            return Messages.Required.EMPLOYEE_NAME.toString();
        }
        if (employeeDto.getEmplSecondName() == null){
            return Messages.Required.EMPLOYEE_SECOND_NAME.toString();
        }
        if (employeeDto.getEmplFirstSurname() == null){
            return Messages.Required.EMPLOYEE_SURNAME.toString();
        }
        if (employeeDto.getEmplSecondSurname() == null){
            return Messages.Required.EMPLOYEE_SECOND_SURNAME.toString();
        }
        if (employeeDto.getEmplEmail() == null){
            return Messages.Required.EMPLOYEE_EMAIL.toString();
        }
        return null;
    }

    private String validateVaccinationInfo(EmployeeDto employeeDto){
        List<VaccinationDto> vaccinationDtoList = (List<VaccinationDto>) employeeDto.getVaccinationsByEmplId();
        List<VaccinationDto> formattedVaccinationDtoList = new ArrayList<>();
        if (vaccinationDtoList == null){
            return Messages.Required.VACCINE_INFORMATION.toString();
        }
        for(VaccinationDto vaccinationDto : vaccinationDtoList){
            if (vaccinationDto.getVaccDoseId()!= null && vaccinationDto.getVaccVaccinationDate() != null){
                formattedVaccinationDtoList.add(vaccinationDto);
            }
        }
        if(formattedVaccinationDtoList.size() == 0){
            return Messages.Required.VACCINE_INFORMATION.toString();
        }
        employeeDto.setVaccinationsByEmplId(formattedVaccinationDtoList);
        return null;
    }

    private void validateVaccinationStatus(EmployeeDto employee) throws ValidationException {
        if (employee.getVastId() == null) {
            employee.setVastId(Constants.NOT_VACCINATED);
        } else if (Constants.VACCINATED.equals(employee.getVastId())){
            String requiredVaccinationMessage = validateVaccinationInfo(employee);
            if (requiredVaccinationMessage != null){
                throw new RequiredException(requiredVaccinationMessage);
            }
            for (VaccinationDto vaccinationDto : employee.getVaccinationsByEmplId()){
                vaccinationDto.setEmplId(employee.getEmplId());
                vaccinationController.create(vaccinationDto);
            }
        } else if (!Constants.NOT_VACCINATED.equals(employee.getVastId())){
            throw new ValidationException(Messages.Errors.INVALID_VACCINE_TYPE.toString());
        }
    }
}
