package com.chad.crudApp.exampleCRUD.service;

import com.chad.crudApp.exampleCRUD.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();

    Employee findById(int id);

    Employee save(Employee e);

    void deleteById(int id);
}
