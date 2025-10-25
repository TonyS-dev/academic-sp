package com.codeup.academic.service;

import java.util.List;

import com.codeup.academic.web.dto.StudentRequest;
import com.codeup.academic.web.dto.StudentResponse;

public interface IStudentService {
    StudentResponse create(StudentRequest req);
    StudentResponse getById(Long id);
    List<StudentResponse> list();
}
