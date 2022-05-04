package com.kruger.vaccineinventory.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "end_user", schema = "public", catalog = "vaccine_inventory")
public class EndUser {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "user_id")
    private int userId;
    @Basic
    @Column(name = "role_id")
    private String roleId;
    @Basic
    @Column(name = "user_name")
    private String userName;
    @Basic
    @Column(name = "user_password")
    private String userPassword;
    @Basic
    @Column(name = "user_modification_date")
    private Date userModificationDate;
    @Basic
    @Column(name = "user_login_count")
    private int userLoginCount;
    @Basic
    @Column(name = "user_old_password")
    private String userOldPassword;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Date getUserModificationDate() {
        return userModificationDate;
    }

    public void setUserModificationDate(Date userModificationDate) {
        this.userModificationDate = userModificationDate;
    }

    public int getUserLoginCount() {
        return userLoginCount;
    }

    public void setUserLoginCount(int userLoginCount) {
        this.userLoginCount = userLoginCount;
    }

    public String getUserOldPassword() {
        return userOldPassword;
    }

    public void setUserOldPassword(String userOldPassword) {
        this.userOldPassword = userOldPassword;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EndUser endUser = (EndUser) o;
        return userId == endUser.userId && userLoginCount == endUser.userLoginCount && Objects.equals(roleId, endUser.roleId) && Objects.equals(userName, endUser.userName) && Objects.equals(userPassword, endUser.userPassword) && Objects.equals(userModificationDate, endUser.userModificationDate) && Objects.equals(userOldPassword, endUser.userOldPassword);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, roleId, userName, userPassword, userModificationDate, userLoginCount, userOldPassword);
    }
}
