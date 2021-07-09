package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    public List<Employee> findAllByOrderByLastNameAsc();

    //public Optional<Employee> findById(int id);

    //public void save(Employee employee);

    //public void deleteById(int id);
}
