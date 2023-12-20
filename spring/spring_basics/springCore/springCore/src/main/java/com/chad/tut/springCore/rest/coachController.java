package com.chad.tut.springCore.rest;

// the class that uses the interface

import com.chad.tut.springCore.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class coachController {

    // dependency
    private Coach mycoach;


    /*

    Setter injection - the method name could technically be of anything but for sake of readability then use set<whatever>

    @Autowired
    public void setCoach(Coach theCoach) {
        this.mycoach = theCoach;
    }

     */

    /*

    Field injection NOT RECOMMENDED

    @Autowired
    private Coach myCoach;


     */


    // constructor based dependency injection
    @Autowired
    coachController(@Qualifier("swim") Coach theCoach) {
        this.mycoach = theCoach;
    }

    // exposing an endpoint "/getdailyworkout"
    @GetMapping("/getdailyworkout")
    public String getWorkout() {
        return mycoach.getWorkout();
    }

}
