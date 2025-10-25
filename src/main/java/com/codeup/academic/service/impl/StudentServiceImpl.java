package com.codeup.academic.service.impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import com.codeup.academic.entity.StudentEntity;
import com.codeup.academic.repository.IStudentRepository;
import com.codeup.academic.service.IStudentService;
import com.codeup.academic.web.dto.StudentRequest;
import com.codeup.academic.web.dto.StudentResponse;

import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements IStudentService {
    private final IStudentRepository studentRepository;

    @Override
    public StudentResponse create(StudentRequest req) {
        if (studentRepository.existsByNameIgnoreCase(req.getName())) {
            throw new IllegalArgumentException("nombre duplicado");
        }
        var e = new StudentEntity();
        e.setName(req.getName());
        e.setAge(req.getAge());
        var saved = studentRepository.save(e);
        
        return new StudentResponse(saved.getId(), saved.getName());
    }

    
    @Transactional(readOnly = true)
    @Override
    public StudentResponse getById(Long id) {
        var e = studentRepository.findById(id).orElseThrow(() -> new NoSuchElementException("usuario no encontrado"));
        return new StudentResponse(e.getId(), e.getName());
    }

    @Transactional(readOnly = true)
    @Override
    public List<StudentResponse> list() {
        return studentRepository.findAll().stream()
                .map(e -> new StudentResponse(e.getId(), e.getName()))
                .toList();
    }

}
