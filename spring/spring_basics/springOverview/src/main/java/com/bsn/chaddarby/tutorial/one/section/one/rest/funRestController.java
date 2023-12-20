package com.bsn.chaddarby.tutorial.one.section.one.rest;

// This is where my API code goes.

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// this is called an annotation

@RestController
public class funRestController {

    // Injecting values specified in application.properities

    @Value("${pokemon.name}")
    private String pokeName;

    @Value("${pokemon.health}")
    // If you have it in int then there seems to be problem
    private String pokeHealth;

    // exposing a "/" endpoint

    @GetMapping("/")
    public String helloWorld() {
        return "Hello, World";
    }

    // exposing a "pokemon" endpoint
    @GetMapping("/pokemon")
    public String pokemon() {
        return "Pokemon name = " + pokeName + ", Pokemon health = " + pokeHealth;
    }

}
