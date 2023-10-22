package com.chad.thymeleaf.learnThymeLeaf.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = promoCodeValidator.class)
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface promoCode {

    // promoCode(value=)
    public String value() default "SUV";

    // promoCode(message=)
    public String message() default "Fucked this up";

    // This is used to group related annotations or constraints together.
    // We are only using the defaults.
    public Class<?>[] groups() default  {};

    // This can be used to provide additional information regarding our error
    // again only using the default
    public Class<? extends Payload>[] payloads() default {};
}
