package com.chad.thymeleaf.learnThymeLeaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class greetingController {

    @RequestMapping("/helloForm")
    public String hello() {
        return "hello";
    }

    @RequestMapping("/processForm")
    public String helloWithName() {
        return "helloWithName";
    }
}
