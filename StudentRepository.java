package com.example.studentapp.repository;

import com.example.studentapp.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Data access layer. Extending JpaRepository gives us
 * save(), findAll(), findById(), deleteById(), etc. for free.
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
