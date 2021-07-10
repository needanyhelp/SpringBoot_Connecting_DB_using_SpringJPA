package com.example.demo.instructor;

import com.example.demo.instructor.entity.Instructor;
import com.example.demo.instructor.repository.InstructorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class InstructorServiceImpl implements InstructorService{
    private final InstructorRepository theInstructorRepository;


    public InstructorServiceImpl(InstructorRepository instructorRepository){
        theInstructorRepository=instructorRepository;
    }


    @Override
    public List<Instructor> findAll(){
        return theInstructorRepository.findAllByOrderByLastNameAsc();
    }

    @Override
    public Instructor findById(int theId){
        Optional<Instructor> result = theInstructorRepository.findById(theId);

        Instructor theInstructor = null;

        if (result.isPresent()) {
            theInstructor = result.get();
        }
        else {
            // we didn't find the employee
            throw new RuntimeException("Did not find employee id - " + theId);
        }

        return theInstructor;
    }

    @Override
    public void save(Instructor theInstructor){
        theInstructorRepository.save(theInstructor);
    }

    @Override
    public void deleteById(int theId){
        theInstructorRepository.deleteById(theId);
    }


}
