package com.kruger.vaccineinventory.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "vaccine_dose", schema = "public", catalog = "vaccine_inventory")
public class VaccineDose {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "vacc_dose_id")
    private String vaccDoseId;
    @Basic
    @Column(name = "vaty_id")
    private String vatyId;
    @Basic
    @Column(name = "dose_id")
    private String doseId;
    @OneToMany(mappedBy = "vaccineDoseByVaccDoseId")
    private Collection<Vaccination> vaccinationsByVaccDoseId;
    @ManyToOne
    @JoinColumn(name = "vaty_id", referencedColumnName = "vaty_id", nullable = false,
            insertable = false, updatable=false)
    private Vaccine vaccineByVatyId;
    @ManyToOne
    @JoinColumn(name = "dose_id", referencedColumnName = "dose_id", nullable = false,
            insertable = false, updatable=false)
    private Dose doseByDoseId;

    public String getVaccDoseId() {
        return vaccDoseId;
    }

    public void setVaccDoseId(String vaccDoseId) {
        this.vaccDoseId = vaccDoseId;
    }

    public String getVatyId() {
        return vatyId;
    }

    public void setVatyId(String vatyId) {
        this.vatyId = vatyId;
    }

    public String getDoseId() {
        return doseId;
    }

    public void setDoseId(String doseId) {
        this.doseId = doseId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VaccineDose that = (VaccineDose) o;
        return Objects.equals(vaccDoseId, that.vaccDoseId) && Objects.equals(vatyId, that.vatyId) && Objects.equals(doseId, that.doseId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vaccDoseId, vatyId, doseId);
    }

    public Collection<Vaccination> getVaccinationsByVaccDoseId() {
        return vaccinationsByVaccDoseId;
    }

    public void setVaccinationsByVaccDoseId(Collection<Vaccination> vaccinationsByVaccDoseId) {
        this.vaccinationsByVaccDoseId = vaccinationsByVaccDoseId;
    }

    public Vaccine getVaccineByVatyId() {
        return vaccineByVatyId;
    }

    public void setVaccineByVatyId(Vaccine vaccineByVatyId) {
        this.vaccineByVatyId = vaccineByVatyId;
    }

    public Dose getDoseByDoseId() {
        return doseByDoseId;
    }

    public void setDoseByDoseId(Dose doseByDoseId) {
        this.doseByDoseId = doseByDoseId;
    }
}
