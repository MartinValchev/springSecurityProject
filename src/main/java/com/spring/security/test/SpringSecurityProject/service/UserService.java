package com.spring.security.test.SpringSecurityProject.service;

import com.spring.security.test.SpringSecurityProject.models.RegistrationModel;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService{
    void register(RegistrationModel registrationModel);
}
