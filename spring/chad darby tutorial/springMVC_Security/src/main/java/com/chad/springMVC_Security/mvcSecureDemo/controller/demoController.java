package com.chad.springMVC_Security.mvcSecureDemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class demoController {

    @GetMapping("/")
    public String getHomePage() {
        return "home";
    }

    // the path must match up with the one specified in security config
    @GetMapping("/login")
    public String getLogin() {
        return "login";
    }

}
