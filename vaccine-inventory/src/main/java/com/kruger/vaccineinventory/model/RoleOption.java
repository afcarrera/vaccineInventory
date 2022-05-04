package com.kruger.vaccineinventory.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "role_option", schema = "public", catalog = "vaccine_inventory")
public class RoleOption {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "role_opti_id")
    private int roleOptiId;
    @Basic
    @Column(name = "role_id")
    private String roleId;
    @Basic
    @Column(name = "opti_id")
    private String optiId;
    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "role_id", nullable = false,
            insertable = false, updatable=false)
    private Role roleByRoleId;
    @ManyToOne
    @JoinColumn(name = "opti_id", referencedColumnName = "opti_id", nullable = false,
            insertable = false, updatable=false)
    private Option optionByOptiId;

    public int getRoleOptiId() {
        return roleOptiId;
    }

    public void setRoleOptiId(int roleOptiId) {
        this.roleOptiId = roleOptiId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getOptiId() {
        return optiId;
    }

    public void setOptiId(String optiId) {
        this.optiId = optiId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoleOption that = (RoleOption) o;
        return roleOptiId == that.roleOptiId && Objects.equals(roleId, that.roleId) && Objects.equals(optiId, that.optiId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleOptiId, roleId, optiId);
    }

    public Role getRoleByRoleId() {
        return roleByRoleId;
    }

    public void setRoleByRoleId(Role roleByRoleId) {
        this.roleByRoleId = roleByRoleId;
    }

    public Option getOptionByOptiId() {
        return optionByOptiId;
    }

    public void setOptionByOptiId(Option optionByOptiId) {
        this.optionByOptiId = optionByOptiId;
    }
}
