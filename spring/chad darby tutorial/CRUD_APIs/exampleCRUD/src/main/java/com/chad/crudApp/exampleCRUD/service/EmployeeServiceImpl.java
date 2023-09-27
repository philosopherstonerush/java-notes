package com.chad.crudApp.exampleCRUD.service;

import com.chad.crudApp.exampleCRUD.dao.EmployeeDAO;
import com.chad.crudApp.exampleCRUD.dao.EmployeeDAOImpl;
import com.chad.crudApp.exampleCRUD.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// Writing this service layer instead of letting rest controller to directly access our DAO's. This helps to ensure that information from multiple sources can be polled here.

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeDAO employeeDAO;

    @Autowired
    EmployeeServiceImpl(EmployeeDAO theemployeeDAO) {
        this.employeeDAO = theemployeeDAO;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    public Employee findById(int id) {
        return employeeDAO.findById(id);
    }

    @Override
    @Transactional
    public Employee save(Employee e) {
        return employeeDAO.save(e);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        employeeDAO.deleteById(id);
    }
}
