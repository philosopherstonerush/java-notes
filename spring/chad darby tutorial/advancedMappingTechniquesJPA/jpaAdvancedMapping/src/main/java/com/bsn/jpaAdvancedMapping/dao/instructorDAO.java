package com.bsn.jpaAdvancedMapping.dao;

import com.bsn.jpaAdvancedMapping.entity.Instructor;
import com.bsn.jpaAdvancedMapping.entity.InstructorDetail;

public interface instructorDAO {

    public void save(Instructor instructor);
    public Instructor findById(int id);
    public void deleteID(int id);
    public InstructorDetail findInstructorDetailById(int id);
    public void deleteInstructorDetailByID(int id);
}
