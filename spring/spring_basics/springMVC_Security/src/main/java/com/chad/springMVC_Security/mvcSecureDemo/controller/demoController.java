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
        return "fancy-login";
    }

    // /leaders --> for managers

    @GetMapping("/leaders")
    public String getLeadersPage() {
        return "leaders";
    }

    // /admin --> for admins

    @GetMapping("/admin")
    public String getAdminPage() {
        return "admin";
    }

    // AccessDenied Page

    @GetMapping("/accessDenied")
    public String getAccessDenied() {
        return "accessdenied";
    }

}
