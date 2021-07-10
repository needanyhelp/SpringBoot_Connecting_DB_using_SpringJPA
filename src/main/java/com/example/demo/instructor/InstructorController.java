package com.example.demo.instructor;

import com.example.demo.employee.entity.Employee;
import com.example.demo.instructor.entity.Instructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@Controller
@RequestMapping("/instructor")
public class InstructorController {

    private InstructorService instructorService;

    public InstructorController(InstructorService theInstructorService) {
        instructorService = theInstructorService;
    }

    // add mapping for "/list"

    @GetMapping("/list")
    public String listEmployees(Model theModel) {

        // get employees from db
        List<Instructor> theInstructor = instructorService.findAll();

        // add to the spring model
        theModel.addAttribute("instructors", theInstructor);

        return "employees/list-instructors";
    }


    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {

        // create model attribute to bind form data
        Employee theEmployee = new Employee();

        theModel.addAttribute("instructor", theEmployee);

        return "employees/Instructor-form";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") int theId,
                                    Model theModel) {

        // get the employee from the service
        Instructor theInstructor = instructorService.findById(theId);

        // set employee as a model attribute to pre-populate the form
        theModel.addAttribute("instructor", theInstructor);

        // send over to our form
        return "employees/Instructor-form";
    }


    @PostMapping("/save")
    public String saveEmployee(
            @ModelAttribute("instructor") @Valid Instructor theInstructor,
            BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "instructor/Instructor-form";
        }
        else {
            // save the employee
            instructorService.save(theInstructor);

            // use a redirect to prevent duplicate submissions
            return "redirect:/instructor/list";
        }
    }


    @GetMapping("/delete")
    public String delete(@RequestParam("instructorId") int theId) {

        // delete the employee
        instructorService.deleteById(theId);

        // redirect to /employees/list
        return "redirect:/instructor/list";

    }
}


















