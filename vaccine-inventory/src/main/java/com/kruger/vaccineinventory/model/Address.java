package com.kruger.vaccineinventory.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Address {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "addr_id")
    private int addrId;
    @Basic
    @Column(name = "empl_id")
    private int emplId;
    @Basic
    @Column(name = "addr_description")
    private String addrDescription;
    @Basic
    @Column(name = "addr_primary")
    private Boolean addrPrimary;
    @ManyToOne
    @JoinColumn(name = "empl_id", referencedColumnName = "empl_id", nullable = false,
            insertable = false, updatable=false)
    private Employee employeeByEmplId;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return addrId == address.addrId && emplId == address.emplId && Objects.equals(addrDescription, address.addrDescription) && Objects.equals(addrPrimary, address.addrPrimary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(addrId, emplId, addrDescription, addrPrimary);
    }

    public Employee getEmployeeByEmplId() {
        return employeeByEmplId;
    }

    public void setEmployeeByEmplId(Employee employeeByEmplId) {
        this.employeeByEmplId = employeeByEmplId;
    }
}
