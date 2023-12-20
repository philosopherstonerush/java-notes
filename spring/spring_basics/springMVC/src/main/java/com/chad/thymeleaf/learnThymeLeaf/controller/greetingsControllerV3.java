package com.chad.thymeleaf.learnThymeLeaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Locale;

@Controller
public class greetingsControllerV3 {

    @RequestMapping("/processFormV3")
    public String processV3Form(@RequestParam("studentName") String theName, Model model) {
        theName = theName.toUpperCase();
        model.addAttribute("V3Message", theName);
        return "helloWithName";
    }
}
