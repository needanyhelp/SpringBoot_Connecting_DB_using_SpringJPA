package com.example.demo.instructor;

import com.example.demo.instructor.entity.Instructor;

import java.util.List;

    public interface InstructorService {

    public List<Instructor> findAll();

    public Instructor findById(int theId);

    public void save(Instructor theInstructor);

    public void deleteById(int theId);

}
