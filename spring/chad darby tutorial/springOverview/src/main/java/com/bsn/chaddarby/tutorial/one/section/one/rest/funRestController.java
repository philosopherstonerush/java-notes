package com.bsn.chaddarby.tutorial.one.section.one.rest;

// This is where my API code goes.

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// this is called an annotation

@RestController
public class funRestController {

    // exposing a "/" endpoint

    @GetMapping("/")
    public String helloWorld() {
        return "Hello, World";
    }

}
