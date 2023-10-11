package com.chad.thymeleaf.learnThymeLeaf.controller;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Locale;

@Controller
public class greetingsController {

    @RequestMapping("/processForm2")
    public String helloWithNameButServlet(HttpServletRequest httpServletRequest, Model model) {

        // Reading the request paramters with httpServletRequest
        String studentName = httpServletRequest.getParameter("studentName");

        // Processing
        studentName = studentName.toUpperCase();

        // Add model data
        model.addAttribute("message", studentName);

        return "helloWithName";
    }
}
