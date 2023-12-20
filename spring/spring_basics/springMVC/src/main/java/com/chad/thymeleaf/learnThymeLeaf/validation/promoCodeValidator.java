package com.chad.thymeleaf.learnThymeLeaf.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;


/**
 *
 *
 * Our logic is to see if the entered string has the appropriate prefix that we decided those field start with.
 *
 *
 */


// Constraint Validator takes in the interface that you defined and the datatype it validates against.
public class promoCodeValidator implements ConstraintValidator<promoCode, String> {

    String promoPrefix;

    // Implement these two methods - Use IDE.

    @Override
    public void initialize(promoCode pp) {

        // Access that @promoCode(value=<whatever>)
        this.promoPrefix = pp.value();
    }

    // Actual method that takes care of business logic.

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        boolean result = false;
        if(s != null) {
            result = s.startsWith(promoPrefix);
        }
        return result;
    }
}
