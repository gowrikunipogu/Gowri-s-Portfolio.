package com.example.studentapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Entry point for the Student Management MVC application.
 *
 * Layers:
 *  - model      -> Student.java (the M in MVC)
 *  - repository -> StudentRepository.java (data access, Spring Data JPA)
 *  - service    -> StudentService.java (business logic, sits between Controller and Repository)
 *  - controller -> StudentController.java (the C in MVC)
 *  - templates  -> Thymeleaf HTML files (the V in MVC)
 */
@SpringBootApplication
public class StudentMvcAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentMvcAppApplication.class, args);
    }
}
