package com.kruger.vaccineinventory.model;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Role {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "role_id")
    private String roleId;
    @Basic
    @Column(name = "role_description")
    private String roleDescription;
    @OneToMany(mappedBy = "roleByRoleId")
    private Collection<RoleOption> roleOptionsByRoleId;

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return Objects.equals(roleId, role.roleId) && Objects.equals(roleDescription, role.roleDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleId, roleDescription);
    }

    public Collection<RoleOption> getRoleOptionsByRoleId() {
        return roleOptionsByRoleId;
    }

    public void setRoleOptionsByRoleId(Collection<RoleOption> roleOptionsByRoleId) {
        this.roleOptionsByRoleId = roleOptionsByRoleId;
    }
}
