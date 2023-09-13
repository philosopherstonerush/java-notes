package com.chad.jpatutorial.CRUDapp.dao;

import com.chad.jpatutorial.CRUDapp.entity.Student;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class studentADAOImpl implements studentDAO {

    // provided by JPA providers
    private EntityManager entityManager;

    @Autowired
    public studentADAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // Do have Transactional here, since you update the database.

    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }

    // You don't have to use @Transactional because it doesnt manipulate the database.
    @Override
    // Why <className>.class? Look it up on readME
    public Student findById(int id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {

        // Remember the Student is the entity's name not database table's
        TypedQuery<Student> theQuery = entityManager.createQuery("from Student", Student.class);
        return theQuery.getResultList();
    }

    //Set named parameters to filter data

    @Override
    public List<Student> findAllByLastName(String lastName) {
       TypedQuery<Student> theQuery = entityManager.createQuery("from Student where lastName=:theData", Student.class);

       // insert the parameter to theData's place
       theQuery.setParameter("theData", lastName);

       return theQuery.getResultList();
    }

    // Updating a student in the database, @Transactional because it involves database manipulation
    @Override
    @Transactional
    public void update(Student student) {

        // Updates the student to the database. You can edit the student here or in the calling function.
        entityManager.merge(student);

        // One other to update is to use:-

        int numberOfRecordsUpdated = entityManager.createQuery("UPDATE Student SET lastName='John'").executeUpdate();

    }

    @Override
    @Transactional
    public void delete(Integer studentId) {

        // Method-1:
        Student stu = entityManager.find(Student.class, studentId);
        entityManager.remove(stu);

        // Method-2:
        // Why executeUpdate again? Well it does technically updating the database.
        int numberOfRecordsDeleted= entityManager.createQuery("DELETE Student WHERE firstName='mydick'").executeUpdate();

    }

    @Override
    @Transactional
    public void deleteAll() {

        int numnerOfRecordsDeleted = entityManager.createQuery("DELETE FROM Student").executeUpdate();

    }
}
