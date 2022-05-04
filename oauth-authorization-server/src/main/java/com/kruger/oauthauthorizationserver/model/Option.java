package com.kruger.oauthauthorizationserver.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Option {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "opti_id")
    private String optiId;
    @Basic
    @Column(name = "opti_name")
    private String optiName;

    public String getOptiId() {
        return optiId;
    }

    public void setOptiId(String optiId) {
        this.optiId = optiId;
    }

    public String getOptiName() {
        return optiName;
    }

    public void setOptiName(String optiName) {
        this.optiName = optiName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Option option = (Option) o;
        return Objects.equals(optiId, option.optiId) && Objects.equals(optiName, option.optiName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(optiId, optiName);
    }
}
