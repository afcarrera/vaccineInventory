package com.kruger.vaccineinventory.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.kruger.vaccineinventory.util.Constants;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AddressDto implements _DTOEntity{
    @JsonProperty(Constants.ID_LABEL)
    private int addrId;
    @JsonProperty(Constants.EMPLOYEE_ID_LABEL)
    private int emplId;
    @JsonProperty(Constants.DESCRIPTION_LABEL)
    private String addrDescription;
    @JsonProperty(Constants.IS_PRIMARY_LABEL)
    private Boolean addrPrimary;

    public int getAddrId() {
        return addrId;
    }

    public void setAddrId(int addrId) {
        this.addrId = addrId;
    }

    public int getEmplId() {
        return emplId;
    }

    public void setEmplId(int emplId) {
        this.emplId = emplId;
    }

    public String getAddrDescription() {
        return addrDescription;
    }

    public void setAddrDescription(String addrDescription) {
        this.addrDescription = addrDescription;
    }

    public Boolean getAddrPrimary() {
        return addrPrimary;
    }

    public void setAddrPrimary(Boolean addrPrimary) {
        this.addrPrimary = addrPrimary;
    }
}
