package com.spring.security.test.SpringSecurityProject.annotations;

import com.spring.security.test.SpringSecurityProject.entities.User;
import com.spring.security.test.SpringSecurityProject.models.RegistrationModel;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class IsMatchingPasswordValidator implements ConstraintValidator<IsPasswordsMatching,Object> {


    @Override
    public void initialize(IsPasswordsMatching constraintAnnotation) {

    }

    @Override
    public boolean isValid(Object userClass, ConstraintValidatorContext constraintValidatorContext) {

        if(userClass instanceof RegistrationModel){
            return ((RegistrationModel)userClass).getPassword()
                    .equals(((RegistrationModel) userClass).getConfirmedPassword());
        }
        return false;
    }
}
