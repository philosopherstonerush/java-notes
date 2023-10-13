package com.chad.thymeleaf.learnThymeLeaf.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class studentController {

    @RequestMapping(value = "/students", method = RequestMethod.GET) {}
    public String showURLs() {

    }
}
