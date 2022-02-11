package com.corpfield.StudentRegistration.dao;

import org.springframework.data.domain.Pageable;

import java.util.List;

public interface StudentDao {
    List<Object[]> getStudentWith(Pageable pageable);

    int getTotalStudents();
}
