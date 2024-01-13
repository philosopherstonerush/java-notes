package com.bsn.tut.aop.service;

import org.springframework.stereotype.Service;

@Service
public class FortuneService {

    public String todays_fortune() {
        System.out.println("YOU ARE THE GREATEST PROGRAMMER EVER");
        return "DONE";
    }

}
