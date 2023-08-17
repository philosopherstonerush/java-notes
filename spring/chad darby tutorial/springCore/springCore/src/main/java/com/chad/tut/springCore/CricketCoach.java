package com.chad.tut.springCore;


// lower level implementation for dependency injection

import org.springframework.stereotype.Component;

// @Component helps it be classified as spring bean without any external code.

@Component
public class CricketCoach implements Coach {

    @Override
    public String getWorkout() {
        return "THROW BALLLLLL";
    }
}
