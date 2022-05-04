package com.kruger.vaccineinventory.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Vaccine {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "vaty_id")
    private String vatyId;
    @Basic
    @Column(name = "vaty_name")
    private String vatyName;
    @OneToMany(mappedBy = "vaccineByVatyId")
    private Collection<VaccineDose> vaccineDosesByVatyId;

    public String getVatyId() {
        return vatyId;
    }

    public void setVatyId(String vatyId) {
        this.vatyId = vatyId;
    }

    public String getVatyName() {
        return vatyName;
    }

    public void setVatyName(String vatyName) {
        this.vatyName = vatyName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vaccine vaccine = (Vaccine) o;
        return Objects.equals(vatyId, vaccine.vatyId) && Objects.equals(vatyName, vaccine.vatyName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vatyId, vatyName);
    }

    public Collection<VaccineDose> getVaccineDosesByVatyId() {
        return vaccineDosesByVatyId;
    }

    public void setVaccineDosesByVatyId(Collection<VaccineDose> vaccineDosesByVatyId) {
        this.vaccineDosesByVatyId = vaccineDosesByVatyId;
    }
}
