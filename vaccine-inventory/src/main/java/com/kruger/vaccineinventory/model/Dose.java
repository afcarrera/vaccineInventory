package com.kruger.vaccineinventory.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Dose {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "dose_id")
    private String doseId;
    @Basic
    @Column(name = "dose_description")
    private String doseDescription;
    @OneToMany(mappedBy = "doseByDoseId")
    private Collection<VaccineDose> vaccineDosesByDoseId;

    public String getDoseId() {
        return doseId;
    }

    public void setDoseId(String doseId) {
        this.doseId = doseId;
    }

    public String getDoseDescription() {
        return doseDescription;
    }

    public void setDoseDescription(String doseDescription) {
        this.doseDescription = doseDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dose dose = (Dose) o;
        return Objects.equals(doseId, dose.doseId) && Objects.equals(doseDescription, dose.doseDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(doseId, doseDescription);
    }

    public Collection<VaccineDose> getVaccineDosesByDoseId() {
        return vaccineDosesByDoseId;
    }

    public void setVaccineDosesByDoseId(Collection<VaccineDose> vaccineDosesByDoseId) {
        this.vaccineDosesByDoseId = vaccineDosesByDoseId;
    }
}
