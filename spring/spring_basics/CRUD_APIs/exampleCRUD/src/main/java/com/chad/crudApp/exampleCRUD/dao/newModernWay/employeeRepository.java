package com.chad.crudApp.exampleCRUD.dao.newModernWay;

import com.chad.crudApp.exampleCRUD.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface employeeRepository extends JpaRepository<Employee, Integer> {

    // Most of the methods involved are already defined.

}
