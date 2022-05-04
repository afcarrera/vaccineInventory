package com.kruger.vaccineinventory.dto;

public class PhoneTypeDto implements _DTOEntity{
    private String phtyId;
    private String phtyName;

    public String getPhtyId() {
        return phtyId;
    }

    public void setPhtyId(String phtyId) {
        this.phtyId = phtyId;
    }

    public String getPhtyName() {
        return phtyName;
    }

    public void setPhtyName(String phtyName) {
        this.phtyName = phtyName;
    }
}
