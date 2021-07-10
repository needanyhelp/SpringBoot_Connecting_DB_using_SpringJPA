package com.example.demo.instructor.repository;

import com.example.demo.instructor.entity.Instructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Integer> {

    public List<Instructor> findAllByOrderByLastNameAsc();
}
