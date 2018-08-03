package com.spring.security.test.SpringSecurityProject.models;

import com.spring.security.test.SpringSecurityProject.annotations.IsPasswordsMatching;

import javax.validation.constraints.Size;

@IsPasswordsMatching
public class RegistrationModel {
    @Size(min=5 , message = "Username cannot be less then 5 characters")
    private String username;

    @Size(min=5 , message = "Password cannot be less then 5 characters")
    private String password;

    private String confirmedPassword;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmedPassword() {
        return confirmedPassword;
    }

    public void setConfirmedPassword(String confirmedPassword) {
        this.confirmedPassword = confirmedPassword;
    }
}
