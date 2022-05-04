package com.kruger.vaccineinventory.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Employee {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "empl_id")
    private int emplId;
    @Basic
    @Column(name = "user_id")
    private int userId;
    @Basic
    @Column(name = "vast_id")
    private String vastId;
    @Basic
    @Column(name = "empl_identification")
    private String emplIdentification;
    @Basic
    @Column(name = "empl_second_name")
    private String emplSecondName;
    @Basic
    @Column(name = "empl_first_surname")
    private String emplFirstSurname;
    @Basic
    @Column(name = "empl_second_surname")
    private String emplSecondSurname;
    @Basic
    @Column(name = "empl_full_name")
    private String emplFullName;
    @Basic
    @Column(name = "empl_email")
    private String emplEmail;
    @OneToMany(mappedBy = "employeeByEmplId")
    private Collection<Address> addressesByEmplId;
    @OneToMany(mappedBy = "employeeByEmplId")
    private Collection<Phone> phonesByEmplId;
    @OneToMany(mappedBy = "employeeByEmplId")
    private Collection<Vaccination> vaccinationsByEmplId;
    @Basic
    @Column(name = "empl_first_name")
    private String emplFirstName;
    @Basic
    @Column(name = "empl_birthday_date")
    private Date emplBirthdayDate;

    public int getEmplId() {
        return emplId;
    }

    public void setEmplId(int emplId) {
        this.emplId = emplId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getVastId() {
        return vastId;
    }

    public void setVastId(String vastId) {
        this.vastId = vastId;
    }

    public String getEmplIdentification() {
        return emplIdentification;
    }

    public void setEmplIdentification(String emplIdentification) {
        this.emplIdentification = emplIdentification;
    }

    public String getEmplSecondName() {
        return emplSecondName;
    }

    public void setEmplSecondName(String emplSecondName) {
        this.emplSecondName = emplSecondName;
    }

    public String getEmplFirstSurname() {
        return emplFirstSurname;
    }

    public void setEmplFirstSurname(String emplFirstSurname) {
        this.emplFirstSurname = emplFirstSurname;
    }

    public String getEmplSecondSurname() {
        return emplSecondSurname;
    }

    public void setEmplSecondSurname(String emplSecondSurname) {
        this.emplSecondSurname = emplSecondSurname;
    }

    public String getEmplFullName() {
        return emplFullName;
    }

    public void setEmplFullName(String emplFullName) {
        this.emplFullName = emplFullName;
    }

    public String getEmplEmail() {
        return emplEmail;
    }

    public void setEmplEmail(String emplEmail) {
        this.emplEmail = emplEmail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return emplId == employee.emplId && userId == employee.userId && Objects.equals(vastId, employee.vastId) && Objects.equals(emplIdentification, employee.emplIdentification) && Objects.equals(emplFirstName, employee.emplFirstName) && Objects.equals(emplSecondName, employee.emplSecondName) && Objects.equals(emplFirstSurname, employee.emplFirstSurname) && Objects.equals(emplSecondSurname, employee.emplSecondSurname) && Objects.equals(emplFullName, employee.emplFullName) && Objects.equals(emplEmail, employee.emplEmail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(emplId, userId, vastId, emplIdentification, emplFirstName, emplSecondName, emplFirstSurname, emplSecondSurname, emplFullName, emplEmail);
    }

    public Collection<Address> getAddressesByEmplId() {
        return addressesByEmplId;
    }

    public void setAddressesByEmplId(Collection<Address> addressesByEmplId) {
        this.addressesByEmplId = addressesByEmplId;
    }

    public Collection<Phone> getPhonesByEmplId() {
        return phonesByEmplId;
    }

    public void setPhonesByEmplId(Collection<Phone> phonesByEmplId) {
        this.phonesByEmplId = phonesByEmplId;
    }

    public Collection<Vaccination> getVaccinationsByEmplId() {
        return vaccinationsByEmplId;
    }

    public void setVaccinationsByEmplId(Collection<Vaccination> vaccinationsByEmplId) {
        this.vaccinationsByEmplId = vaccinationsByEmplId;
    }

    public String getEmplFirstName() {
        return emplFirstName;
    }

    public void setEmplFirstName(String emplFirstName) {
        this.emplFirstName = emplFirstName;
    }

    public Date getEmplBirthdayDate() {
        return emplBirthdayDate;
    }

    public void setEmplBirthdayDate(Date emplBirthdayDate) {
        this.emplBirthdayDate = emplBirthdayDate;
    }
}
