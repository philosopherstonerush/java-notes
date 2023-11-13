package com.bsn.jpaAdvancedMapping.dao;

import com.bsn.jpaAdvancedMapping.entity.Instructor;
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

}
