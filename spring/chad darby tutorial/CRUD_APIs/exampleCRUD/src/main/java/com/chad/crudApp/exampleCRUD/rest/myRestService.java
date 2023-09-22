package com.chad.crudApp.exampleCRUD.rest;

import com.chad.crudApp.exampleCRUD.entity.Student;
import com.chad.crudApp.exampleCRUD.entity.StudentErrorResponse;
import com.chad.crudApp.exampleCRUD.exceptionClasses.response.StudentException;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
// Sets the upper level from root path. for example: root/test/hello
@RequestMapping("/test")
public class myRestService {

    private ArrayList<Student> studentlist;

    // Post-Construct helps you to run certain tasks AFTER this bean is created.
    // Here we use it to load the arrayList

    @PostConstruct
    public void loadStudents() {
        this.studentlist = new ArrayList<>();

        Student s1 = new Student("john", "smith");
        Student s2 = new Student("meena", "subbaraj");
        Student s3 = new Student("baratharaj", "algar");

        studentlist.add(s1);
        studentlist.add(s2);
        studentlist.add(s3);
    }

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello World";
    }

    @GetMapping("/students")
    // Thanks to jackson package, the List<Student> gets serialized to JSON behind the scenes.
    public List<Student> getStudentsList() {
        return studentlist;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {

        // our custom exception handling.
        if(studentId < 0 || studentId > studentlist.size() ) {
            throw new StudentException("Index out of bounds");
        }

        return studentlist.get(studentId);
    }

    // Below two exception handlers are restricted to this rest controller. Commenting it and adding these to global handler

    // Exception to handle if an invalid index is given

    /*
        @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentException studentException) {

        StudentErrorResponse studentErrorResponse = new StudentErrorResponse();

        studentErrorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        studentErrorResponse.setMessage(studentException.getMessage());
        studentErrorResponse.setTimeStamp(System.currentTimeMillis());

        // returning our response. You don't have to do JSON convertions, Jackson does it for you.
        return new ResponseEntity<StudentErrorResponse>(studentErrorResponse, HttpStatus.NOT_FOUND);
    }
     */


    // Exception handler to handle every exception, what if you sent something like "first" when an integer is expected.

    /*
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleEveryException(Exception exc) {
        StudentErrorResponse studentErrorResponse = new StudentErrorResponse();

        studentErrorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        studentErrorResponse.setMessage(exc.getMessage());
        studentErrorResponse.setTimeStamp(System.currentTimeMillis());

        // returning our response. You don't have to do JSON convertions, Jackson does it for you.
        return new ResponseEntity<StudentErrorResponse>(studentErrorResponse, HttpStatus.BAD_REQUEST);
    }
     */


}

