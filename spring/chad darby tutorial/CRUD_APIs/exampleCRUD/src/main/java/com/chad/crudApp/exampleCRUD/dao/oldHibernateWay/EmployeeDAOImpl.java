package com.chad.crudApp.exampleCRUD.dao.oldHibernateWay;

import com.chad.crudApp.exampleCRUD.dao.oldHibernateWay.EmployeeDAO;
import com.chad.crudApp.exampleCRUD.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    private EntityManager entityManager;

    @Autowired
    EmployeeDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee", Employee.class);

        return theQuery.getResultList();
    }

    @Override
    public Employee findById(int id) {
        Employee foundEmployee = entityManager.find(Employee.class, id);
        return foundEmployee;
    }

    // Technically the below two methods must have @Transactional annotation but since the best practice is to use in service layer, we havent mentioned it here.

    @Override
    public Employee save(Employee e) {
        Employee dbEmployee = entityManager.merge(e);
        return dbEmployee;
    }

    @Override
    public void deleteById(int id) {
        Employee deletedEmployee = entityManager.find(Employee.class, id);
        entityManager.remove(deletedEmployee);
    }
}
