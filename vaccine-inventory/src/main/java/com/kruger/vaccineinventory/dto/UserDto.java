package com.kruger.vaccineinventory.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.sql.Date;
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto implements _DTOEntity{
    private int userId;
    private String roleId;
    private String userName;
    private String userPassword;
    private Date userModificationDate;
    private int userLoginCount;
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
}
