package com.chad.crudApp.exampleCRUD.rest;

import com.chad.crudApp.exampleCRUD.dao.EmployeeDAO;
import com.chad.crudApp.exampleCRUD.dao.EmployeeDAOImpl;
import com.chad.crudApp.exampleCRUD.entity.Employee;
import com.chad.crudApp.exampleCRUD.service.EmployeeService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class EmployeeRestController {

    // Delegating direct DAO control to a service layer.

    private EmployeeService employeeService;

    @Autowired
    EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> allEmployees() {
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId) {
        Employee e =  employeeService.findById(employeeId);
        if(e == null) {
            throw new RuntimeException("Employee id not found");
        }
        return e;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee) {

        theEmployee.setId(0);
        Employee dbEmployee = employeeService.save(theEmployee);
        return dbEmployee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee) {

        return employeeService.save(theEmployee);
    }

    @DeleteMapping("/employees/{employeeId}")
    public int deleteEmployee(@PathVariable int employeeId) {
        Employee dbEmployee = employeeService.findById(employeeId);
        employeeService.deleteById(employeeId);
        return dbEmployee.getId();
    }
}
