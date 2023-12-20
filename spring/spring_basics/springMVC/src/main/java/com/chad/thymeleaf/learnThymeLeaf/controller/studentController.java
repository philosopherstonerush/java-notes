package com.chad.thymeleaf.learnThymeLeaf.controller;

import com.chad.thymeleaf.learnThymeLeaf.model.student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class studentController {

    @Value("${countries}")
    private List<String> countriesFromApplicationProp;

    @Value("${languages}")
    private List<String> languages;

    @Value("${systems}")
    private List<String> systems;

    @RequestMapping(value = "/showStudentsForm", method = RequestMethod.GET)
    public String showURL(Model model) {

        student theStudent = new student();

        // sending in the object
        model.addAttribute("student", theStudent);
        model.addAttribute("countries", countriesFromApplicationProp);
        model.addAttribute("languages", languages);
        model.addAttribute("systems", systems);

        return "student-form";

    }

    @RequestMapping(value = "/processStudentForm", method = RequestMethod.POST)
    public String processURL(@ModelAttribute("student") student theStudent) {
        return "student-confirmation";
    }
}
