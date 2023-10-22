package com.chad.thymeleaf.learnThymeLeaf.controller;

import com.chad.thymeleaf.learnThymeLeaf.model.customer;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class customerController {

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @RequestMapping(value = "/customer-form", method = RequestMethod.GET)
    public String getCustomerForm(Model theModel) {

        // sending in the new customer to bind the data to.
        theModel.addAttribute("customer", new customer());
        return "customer-form";
    }

    @RequestMapping(value = "/process-form", method = RequestMethod.POST)
    public String processCustomerForm(
            @Valid customer theCustomer,
            BindingResult bindingResult
    ) {

        if(bindingResult.hasErrors()) {
            return "customer-form";
        } else {
            return "customer-confirmation";
        }
    }

}
