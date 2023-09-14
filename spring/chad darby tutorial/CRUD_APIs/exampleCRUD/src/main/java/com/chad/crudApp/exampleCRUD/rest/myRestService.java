package com.chad.crudApp.exampleCRUD.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
// Sets the upper level from root path. for example: root/test/hello
@RequestMapping("/test")
public class myRestService {

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello World";
    }
}
