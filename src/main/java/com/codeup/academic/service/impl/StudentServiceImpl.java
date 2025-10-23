package com.codeup.academic.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codeup.academic.domain.Student;
import com.codeup.academic.repository.IStudentRepository;

@Service
public class StudentServiceImpl {
    private final IStudentRepository studentRepository;

    public StudentServiceImpl(IStudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student create(Student student) {
        try {
            /* import org.springframework.util.StringUtils;

if (!StringUtils.hasText(student.getName())) {
    throw new IllegalArgumentException("Name is required");
} */
            if (student.getAge() == 0 || student.getName().trim() == null) 
            {
                throw new IllegalArgumentException("Student name and age cannot be null.");
            }

            if (student.getAge() < 4) {
                throw new IllegalArgumentException("Student age must be at least 4 years old.");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return studentRepository.save(student);
    }

    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    public Optional<Student> getById(Long id) {
        return studentRepository.findById(id);
    }

    public Student updateStudent(Long id, Student student) {
        // Check that the student exists
        if (studentRepository.findById(id).isEmpty()) {
            throw new IllegalArgumentException("Student not found with ID: " + id);
        }
        
        // Business validations
        if (student.getAge() < 4) {
            throw new IllegalArgumentException("Student must be at least 4 years old");
        }
        
        // Ensure the correct ID is used
        student.setId(id);

        return studentRepository.save(student);
    }

    public void delete(Long id) {
        studentRepository.deleteById(id);
    }
}
