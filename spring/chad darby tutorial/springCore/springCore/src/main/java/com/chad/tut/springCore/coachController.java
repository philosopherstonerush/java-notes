package com.chad.tut.springCore;

// the class that uses the interface

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class coachController {

    // dependency
    private Coach mycoach;


    // constructor based dependency injection
    @Autowired
    coachController(Coach theCoach) {
        this.mycoach = theCoach;
    }

    // exposing an endpoint "/getdailyworkout"
    @GetMapping("/getdailyworkout")
    public String getWorkout() {
        return mycoach.getWorkout();
    }

}
