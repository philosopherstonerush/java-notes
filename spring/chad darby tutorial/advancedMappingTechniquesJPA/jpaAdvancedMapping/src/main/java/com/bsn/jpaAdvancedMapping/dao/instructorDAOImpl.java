package com.bsn.jpaAdvancedMapping.dao;

import com.bsn.jpaAdvancedMapping.entity.Instructor;
import com.bsn.jpaAdvancedMapping.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class instructorDAOImpl  implements instructorDAO{

    EntityManager entityManager;

    @Autowired
    instructorDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    public void save(Instructor instructor) {
        entityManager.persist(instructor);
    }

    @Override
    public Instructor findById(int id) {
        return entityManager.find(Instructor.class, id);
    }

    @Override
    @Transactional
    public void deleteID(int id) {
        Instructor temp = entityManager.find(Instructor.class, id);
        entityManager.remove(temp);
    }

    @Override
    public InstructorDetail findInstructorDetailById(int id) {
        return entityManager.find(InstructorDetail.class, id);
    }

    @Transactional
    public void deleteInstructorDetailByID(int id) {
        InstructorDetail tmp = entityManager.find(InstructorDetail.class, id);
        entityManager.remove(tmp);
    }

    // This is only if you dont want to propagate delete operation to parent entity vice versa
    @Transactional
    public void deleteInstructorDetailByIdSpecial(int id) {
        InstructorDetail temp = entityManager.find(InstructorDetail.class, id);
        Instructor ins = temp.getInstructor();
        ins.setInstructorDetail(null);
        entityManager.remove(temp);
    }

}
