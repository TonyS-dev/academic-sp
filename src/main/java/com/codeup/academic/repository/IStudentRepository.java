package com.codeup.academic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codeup.academic.domain.Student;

@Repository
public interface IStudentRepository extends JpaRepository<Student, Long> {

}
