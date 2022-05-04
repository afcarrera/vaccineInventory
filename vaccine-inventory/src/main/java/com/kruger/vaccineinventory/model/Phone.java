package com.kruger.vaccineinventory.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Phone {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "phon_id")
    private int phonId;
    @Basic
    @Column(name = "empl_id")
    private int emplId;
    @Basic
    @Column(name = "phty_id")
    private String phtyId;
    @Basic
    @Column(name = "phon_number")
    private String phonNumber;
    @Basic
    @Column(name = "phon_primary")
    private Boolean phonPrimary;
    @ManyToOne
    @JoinColumn(name = "empl_id", referencedColumnName = "empl_id", nullable = false,
            insertable = false, updatable=false)
    private Employee employeeByEmplId;
    @ManyToOne
    @JoinColumn(name = "phty_id", referencedColumnName = "phty_id", nullable = false,
            insertable = false, updatable=false)
    private PhoneType phoneTypeByPhtyId;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Phone phone = (Phone) o;
        return phonId == phone.phonId && emplId == phone.emplId && Objects.equals(phtyId, phone.phtyId) && Objects.equals(phonNumber, phone.phonNumber) && Objects.equals(phonPrimary, phone.phonPrimary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(phonId, emplId, phtyId, phonNumber, phonPrimary);
    }

    public Employee getEmployeeByEmplId() {
        return employeeByEmplId;
    }

    public void setEmployeeByEmplId(Employee employeeByEmplId) {
        this.employeeByEmplId = employeeByEmplId;
    }

    public PhoneType getPhoneTypeByPhtyId() {
        return phoneTypeByPhtyId;
    }

    public void setPhoneTypeByPhtyId(PhoneType phoneTypeByPhtyId) {
        this.phoneTypeByPhtyId = phoneTypeByPhtyId;
    }
}
