package com.chad.crudApp.exampleCRUD.dao;

import com.chad.crudApp.exampleCRUD.entity.Employee;
import com.chad.crudApp.exampleCRUD.service.EmployeeService;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();

    Employee findById(int id);

    Employee save(Employee e);

    void deleteById(int id);

}
