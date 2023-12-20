package com.chad.tut.springCore.common;

import org.springframework.web.bind.annotation.GetMapping;

/*

Assume its a third party class - We use bean to have it be able to use with spring container. Go to config.

 */

public class swimCoach implements Coach{


    @Override
    public String getWorkout() {
        return "swim 100000 meters";
    }
}
