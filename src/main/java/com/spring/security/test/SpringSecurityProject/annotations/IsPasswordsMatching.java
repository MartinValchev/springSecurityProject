package com.spring.security.test.SpringSecurityProject.annotations;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Constraint(validatedBy = IsMatchingPasswordValidator.class)
public @interface IsPasswordsMatching {
    String message() default "Passwords do not match";

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}