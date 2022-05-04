package com.kruger.vaccineinventory.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.kruger.vaccineinventory.util.Constants;

import java.sql.Date;
import java.util.Collection;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmployeeDto implements _DTOEntity {
    @JsonProperty(Constants.ID_LABEL)
    private int emplId;
    @JsonProperty(Constants.USER_ID_LABEL)
    private int userId;
    @JsonProperty(Constants.VACCINATION_STATUS_ID_LABEL)
    private String vastId;
    @JsonProperty(Constants.IDENTIFICATION_LABEL)
    private String emplIdentification;
    @JsonProperty(Constants.FIRST_NAME_LABEL)
    private String emplFirstName;
    @JsonProperty(Constants.SECOND_NAME_LABEL)
    private String emplSecondName;
    @JsonProperty(Constants.FIRST_SURNAME_LABEL)
    private String emplFirstSurname;
    @JsonProperty(Constants.SECOND_SURNAME_LABEL)
    private String emplSecondSurname;
    @JsonProperty(Constants.FULL_NAME_LABEL)
    private String emplFullName;
    @JsonProperty(Constants.EMAIL_LABEL)
    private String emplEmail;
    @JsonProperty(Constants.BIRTHDAY_DATE_LABEL)
    private Date emplBirthdayDate;
    @JsonProperty(Constants.ADDRESSES_LABEL)
    private Collection<AddressDto> addressesByEmplId;
    @JsonProperty(Constants.PHONES_LABEL)
    private Collection<PhoneDto> phonesByEmplId;
    @JsonProperty(Constants.VACCINATIONS_LABEL)
    private Collection<VaccinationDto> vaccinationsByEmplId;
    @JsonProperty(Constants.USER_LABEL)
    private UserDto userDto;

    public int getEmplId() {
        return emplId;
    }

    public void setEmplId(int emplId) {
        this.emplId = emplId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getVastId() {
        return vastId;
    }

    public void setVastId(String vastId) {
        this.vastId = vastId;
    }

    public String getEmplIdentification() {
        return emplIdentification;
    }

    public void setEmplIdentification(String emplIdentification) {
        this.emplIdentification = emplIdentification;
    }

    public String getEmplFirstName() {
        return emplFirstName;
    }

    public void setEmplFirstName(String emplFirstName) {
        this.emplFirstName = emplFirstName;
    }

    public String getEmplSecondName() {
        return emplSecondName;
    }

    public void setEmplSecondName(String emplSecondName) {
        this.emplSecondName = emplSecondName;
    }

    public String getEmplFirstSurname() {
        return emplFirstSurname;
    }

    public void setEmplFirstSurname(String emplFirstSurname) {
        this.emplFirstSurname = emplFirstSurname;
    }

    public String getEmplSecondSurname() {
        return emplSecondSurname;
    }

    public void setEmplSecondSurname(String emplSecondSurname) {
        this.emplSecondSurname = emplSecondSurname;
    }

    public String getEmplFullName() {
        return emplFullName;
    }

    public void setEmplFullName(String emplFullName) {
        this.emplFullName = emplFullName;
    }

    public String getEmplEmail() {
        return emplEmail;
    }

    public void setEmplEmail(String emplEmail) {
        this.emplEmail = emplEmail;
    }

    public Collection<AddressDto> getAddressesByEmplId() {
        return addressesByEmplId;
    }

    public void setAddressesByEmplId(Collection<AddressDto> addressesByEmplId) {
        this.addressesByEmplId = addressesByEmplId;
    }

    public Collection<PhoneDto> getPhonesByEmplId() {
        return phonesByEmplId;
    }

    public void setPhonesByEmplId(Collection<PhoneDto> phonesByEmplId) {
        this.phonesByEmplId = phonesByEmplId;
    }

    public Collection<VaccinationDto> getVaccinationsByEmplId() {
        return vaccinationsByEmplId;
    }

    public void setVaccinationsByEmplId(Collection<VaccinationDto> vaccinationsByEmplId) {
        this.vaccinationsByEmplId = vaccinationsByEmplId;
    }

    public Date getEmplBirthdayDate() {
        return emplBirthdayDate;
    }

    public void setEmplBirthdayDate(Date emplBirthdayDate) {
        this.emplBirthdayDate = emplBirthdayDate;
    }

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }
}
