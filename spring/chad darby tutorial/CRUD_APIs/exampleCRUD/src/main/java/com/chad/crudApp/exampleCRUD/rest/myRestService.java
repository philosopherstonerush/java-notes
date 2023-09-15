package com.chad.crudApp.exampleCRUD.rest;

import com.chad.crudApp.exampleCRUD.entity.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
// Sets the upper level from root path. for example: root/test/hello
@RequestMapping("/test")
public class myRestService {

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello World";
    }

    @GetMapping("/students")
    // Thanks to jackson package, the List<Student> gets serialized to JSON behind the scenes.
    public List<Student> getStudentsList() {
        List<Student> studentlist = new ArrayList<>();

        Student s1 = new Student("john", "smith");
        Student s2 = new Student("meena", "subbaraj");

        studentlist.add(s1);
        studentlist.add(s2);

        return studentlist;
    }
}

