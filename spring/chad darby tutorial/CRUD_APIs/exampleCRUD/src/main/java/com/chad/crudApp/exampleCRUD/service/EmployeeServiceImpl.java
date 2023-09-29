package com.chad.crudApp.exampleCRUD.service;

import com.chad.crudApp.exampleCRUD.dao.newModernWay.employeeRepository;
import com.chad.crudApp.exampleCRUD.dao.oldHibernateWay.EmployeeDAO;
import com.chad.crudApp.exampleCRUD.entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// Writing this service layer instead of letting rest controller to directly access our DAO's. This helps to ensure that information from multiple sources can be polled here.

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private employeeRepository empRepository;

    @Autowired
    EmployeeServiceImpl(employeeRepository empRepository) {
        this.empRepository = empRepository;
    }

    @Override
    public List<Employee> findAll() {
        return empRepository.findAll();
    }

    @Override
    public Employee findById(int id) {
        Optional<Employee> result = empRepository.findById(id);
        Employee theEmployee = null;
        if(result.isPresent()) {
            theEmployee = result.get();
        }
        return theEmployee;
    }

    @Override
    @Transactional // Transactional isn't needed when you use the JpaRepository as that interface provides transaction support out of the box.
    public Employee save(Employee e) {
        return empRepository.save(e);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        empRepository.deleteById(id);
    }
}
