package com.kruger.vaccineinventory.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "phone_type", schema = "public", catalog = "vaccine_inventory")
public class PhoneType {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "phty_id")
    private String phtyId;
    @Basic
    @Column(name = "phty_name")
    private String phtyName;
    @OneToMany(mappedBy = "phoneTypeByPhtyId")
    private Collection<Phone> phonesByPhtyId;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhoneType phoneType = (PhoneType) o;
        return Objects.equals(phtyId, phoneType.phtyId) && Objects.equals(phtyName, phoneType.phtyName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(phtyId, phtyName);
    }

    public Collection<Phone> getPhonesByPhtyId() {
        return phonesByPhtyId;
    }

    public void setPhonesByPhtyId(Collection<Phone> phonesByPhtyId) {
        this.phonesByPhtyId = phonesByPhtyId;
    }
}
