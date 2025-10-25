package com.codeup.academic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codeup.academic.entity.StudentEntity;

@Repository
public interface IStudentRepository extends JpaRepository<StudentEntity, Long> {
    boolean existsByNameIgnoreCase(String name);
}
