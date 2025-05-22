package com.doyur.demo.dto.request;

import com.doyur.demo.model.Role;
import lombok.Builder;

import java.util.Set;

@Builder
public class CreateUserRequest{
    private String userFName;
    private String userLName;
    private String userPassword;
    private String userEmail;
    private String userPhone;
    private Set<Role> authorities;

    CreateUserRequest() {

    }

    CreateUserRequest(String userFName, String userLName, String userPassword, String userEmail, String userPhone, Set<Role> authorities) {
        this.userFName = userFName;
        this.userLName = userLName;
        this.userPassword = userPassword;
        this.userEmail = userEmail;
        this.userPhone = userPhone;
        this.authorities = authorities;
    }

    public String getUserFName() {
        return userFName;
    }

    public void setUserFName(String userFName) {
        this.userFName = userFName;
    }

    public String getUserLName() {
        return userLName;
    }

    public void setUserLName(String userLName) {
        this.userLName = userLName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public Set<Role> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<Role> authorities) {
        this.authorities = authorities;
    }
}
