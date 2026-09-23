package com.example.studentapp.controller;

import com.example.studentapp.model.Student;
import com.example.studentapp.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

/**
 * Controller layer (the C in MVC).
 * Handles HTTP requests, talks to the Service layer, and picks
 * which Thymeleaf template (View) to render.
 */
@Controller
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // Show the registration form + student list
    @GetMapping({"", "/"})
    public String index(Model model) {
        model.addAttribute("student", new Student());
        model.addAttribute("students", studentService.getAllStudents());
        return "index"; // resolves to templates/index.html
    }

    // Handle form submission
    @PostMapping
    public String registerStudent(@Valid @ModelAttribute("student") Student student,
                                   BindingResult result,
                                   Model model) {
        if (result.hasErrors()) {
            // Validation failed - re-render the form with errors and existing list
            model.addAttribute("students", studentService.getAllStudents());
            return "index";
        }
        studentService.saveStudent(student);
        return "redirect:/students";
    }

    // Delete a student
    @PostMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
        return "redirect:/students";
    }
}
