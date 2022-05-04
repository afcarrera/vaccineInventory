package com.kruger.vaccineinventory.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Vaccination {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "vacc_id")
    private int vaccId;
    @Basic
    @Column(name = "vacc_dose_id")
    private String vaccDoseId;
    @Basic
    @Column(name = "empl_id")
    private int emplId;
    @Basic
    @Column(name = "vacc_vaccination_date")
    private Date vaccVaccinationDate;
    @ManyToOne
    @JoinColumn(name = "vacc_dose_id", referencedColumnName = "vacc_dose_id", nullable = false,
            insertable = false, updatable=false)
    private VaccineDose vaccineDoseByVaccDoseId;
    @ManyToOne
    @JoinColumn(name = "empl_id", referencedColumnName = "empl_id", nullable = false,
            insertable = false, updatable=false)
    private Employee employeeByEmplId;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vaccination that = (Vaccination) o;
        return vaccId == that.vaccId && emplId == that.emplId && Objects.equals(vaccDoseId, that.vaccDoseId) && Objects.equals(vaccVaccinationDate, that.vaccVaccinationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vaccId, vaccDoseId, emplId, vaccVaccinationDate);
    }

    public VaccineDose getVaccineDoseByVaccDoseId() {
        return vaccineDoseByVaccDoseId;
    }

    public void setVaccineDoseByVaccDoseId(VaccineDose vaccineDoseByVaccDoseId) {
        this.vaccineDoseByVaccDoseId = vaccineDoseByVaccDoseId;
    }

    public Employee getEmployeeByEmplId() {
        return employeeByEmplId;
    }

    public void setEmployeeByEmplId(Employee employeeByEmplId) {
        this.employeeByEmplId = employeeByEmplId;
    }
}
