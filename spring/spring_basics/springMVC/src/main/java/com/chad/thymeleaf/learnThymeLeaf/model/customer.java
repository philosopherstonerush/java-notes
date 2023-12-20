package com.chad.thymeleaf.learnThymeLeaf.model;

import com.chad.thymeleaf.learnThymeLeaf.validation.promoCode;
import jakarta.validation.constraints.*;

public class customer {

    private String firstName;

    // validation - NotNull cannot be left blank
    // Size = atleast 1 character must be present
    @NotNull
    @Size(min = 1)
    private String lastName;

    @NotNull
    @Max(value=100, message = "maximum is 100 years old")
    @Min(value = 18, message = "minimum 18 years old")
    // not int because then @NotNull would throw an error, see more in readme
    private Integer age;

    @Pattern(regexp="^[0-9]{5}", message = "input only 5 digits")
    private String postalCode;

    // you can send in value and message to override the default.
    @promoCode
    private String promo;

    public customer() {

    }

    public String getPromo() {
        return promo;
    }

    public void setPromo(String promo) {
        this.promo = promo;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
