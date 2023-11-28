package com.bsn.jpaAdvancedMapping.dao;

import com.bsn.jpaAdvancedMapping.entity.Course;
import com.bsn.jpaAdvancedMapping.entity.Instructor;
import com.bsn.jpaAdvancedMapping.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Type;
import java.util.List;

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

    @Override
    public List<Course> findCoursesByInstructorId(int id) {
        TypedQuery<Course> query = entityManager.createQuery(
                "from Course where instructor.id = :data",
                Course.class
                );
        query.setParameter("data", id);
        List<Course> courses = query.getResultList();
        return courses;
    }

    @Override
    public Instructor findInstructorByIdWithCourses(int id) {
        TypedQuery query = entityManager.createQuery(
                "select i from Instructor i"
                + "JOIN FETCH i.courses"
                + "where i.id = :data", Instructor.class
        );

        query.setParameter("data", id);
        Instructor in = (Instructor) query.getSingleResult();
        return in;
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
