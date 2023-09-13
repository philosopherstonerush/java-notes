package com.chad.jpatutorial.CRUDapp.dao;

import com.chad.jpatutorial.CRUDapp.entity.Student;

import java.util.List;

public interface studentDAO {

    public void save(Student student);

    public Student findById(int id);

    public List<Student> findAll();

    public List<Student> findAllByLastName(String lastName);

    public void update(Student student);

    public void delete(Integer studentId);

    public void deleteAll();
}
