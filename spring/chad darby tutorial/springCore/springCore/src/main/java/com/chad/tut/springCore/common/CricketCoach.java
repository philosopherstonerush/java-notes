package com.chad.tut.springCore.common;


// lower level implementation for dependency injection

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

// @Component helps it be classified as spring bean without any external code.

@Component
@Primary
/*
@Lazy

Do not create this bean when the app starts.
 */

/*

@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)

 */
public class CricketCoach implements Coach {

    /*

    Called after initialization.

     */
    @PostConstruct
    public void doTheThing() {
        return;
    }

    /*

    Called before destruction.

     */

    @PreDestroy
    public void doTheOtherThingZuLee() {
        return;
    }

    @Override
    public String getWorkout() {
        return "THROW BALLLLLL";
    }
}
