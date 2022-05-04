package com.kruger.vaccineinventory.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "vaccination_status", schema = "public", catalog = "vaccine_inventory")
public class VaccinationStatus {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "vast_id")
    private String vastId;
    @Basic
    @Column(name = "vast_status")
    private String vastStatus;

    public String getVastId() {
        return vastId;
    }

    public void setVastId(String vastId) {
        this.vastId = vastId;
    }

    public String getVastStatus() {
        return vastStatus;
    }

    public void setVastStatus(String vastStatus) {
        this.vastStatus = vastStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VaccinationStatus that = (VaccinationStatus) o;
        return Objects.equals(vastId, that.vastId) && Objects.equals(vastStatus, that.vastStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vastId, vastStatus);
    }
}
