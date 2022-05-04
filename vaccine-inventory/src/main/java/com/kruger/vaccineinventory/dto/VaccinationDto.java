package com.kruger.vaccineinventory.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.kruger.vaccineinventory.util.Constants;

import java.sql.Date;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VaccinationDto implements _DTOEntity{
    @JsonProperty(Constants.ID_LABEL)
    private int vaccId;
    @JsonProperty(Constants.DOSE_ID_LABEL)
    private String vaccDoseId;
    @JsonProperty(Constants.EMPLOYEE_ID_LABEL)
    private int emplId;
    @JsonProperty(Constants.DATE_LABEL)
    private Date vaccVaccinationDate;

    public int getVaccId() {
        return vaccId;
    }

    public void setVaccId(int vaccId) {
        this.vaccId = vaccId;
    }

    public String getVaccDoseId() {
        return vaccDoseId;
    }

    public void setVaccDoseId(String vaccDoseId) {
        this.vaccDoseId = vaccDoseId;
    }

    public int getEmplId() {
        return emplId;
    }

    public void setEmplId(int emplId) {
        this.emplId = emplId;
    }

    public Date getVaccVaccinationDate() {
        return vaccVaccinationDate;
    }

    public void setVaccVaccinationDate(Date vaccVaccinationDate) {
        this.vaccVaccinationDate = vaccVaccinationDate;
    }
}
