package com.bsn.jpaAdvancedMapping.dao;

import com.bsn.jpaAdvancedMapping.entity.Course;
import com.bsn.jpaAdvancedMapping.entity.Instructor;
import com.bsn.jpaAdvancedMapping.entity.InstructorDetail;

import java.util.List;

public interface instructorDAO {

    public void save(Instructor instructor);
    public Instructor findById(int id);
    public void deleteID(int id);
    public InstructorDetail findInstructorDetailById(int id);
    public void deleteInstructorDetailByID(int id);
    public List<Course>  findCoursesByInstructorId(int id);
    public Instructor findInstructorByIdWithCourses(int id);
}
