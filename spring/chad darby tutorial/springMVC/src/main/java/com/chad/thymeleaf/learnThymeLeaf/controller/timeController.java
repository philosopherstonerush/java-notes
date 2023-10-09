package com.chad.thymeleaf.learnThymeLeaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;

@Controller
public class timeController {

    @GetMapping("/time")
    public String getTime(Model theModel) {
        String time = String.valueOf(new Date());
        theModel.addAttribute("theDate", time);
        return "time";
    }
}
