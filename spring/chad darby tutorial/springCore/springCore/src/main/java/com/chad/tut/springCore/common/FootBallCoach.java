package com.chad.tut.springCore.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FootBallCoach implements Coach{

    @Override
    public String getWorkout() {
        return "GET THE FOOTBALL MAGGOT";
    }
}
