package com.kruger.vaccineinventory.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.kruger.vaccineinventory.util.Constants;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PhoneDto implements _DTOEntity{
    @JsonProperty(Constants.ID_LABEL)
    private int phonId;
    @JsonProperty(Constants.EMPLOYEE_ID_LABEL)
    private int emplId;
    @JsonProperty(Constants.TYPE_LABEL)
    private String phtyId;
    @JsonProperty(Constants.NUMBER_LABEL)
    private String phonNumber;
    @JsonProperty(Constants.IS_PRIMARY_LABEL)
    private Boolean phonPrimary;

    public int getPhonId() {
        return phonId;
    }

    public void setPhonId(int phonId) {
        this.phonId = phonId;
    }

    public int getEmplId() {
        return emplId;
    }

    public void setEmplId(int emplId) {
        this.emplId = emplId;
    }

    public String getPhtyId() {
        return phtyId;
    }

    public void setPhtyId(String phtyId) {
        this.phtyId = phtyId;
    }

    public String getPhonNumber() {
        return phonNumber;
    }

    public void setPhonNumber(String phonNumber) {
        this.phonNumber = phonNumber;
    }

    public Boolean getPhonPrimary() {
        return phonPrimary;
    }

    public void setPhonPrimary(Boolean phonPrimary) {
        this.phonPrimary = phonPrimary;
    }

}
