package com.corpfield.StudentRegistration.Dao;

import org.springframework.data.domain.Pageable;

import java.util.List;

public interface StudentDao {
    List<Object[]> getStudentWith(Pageable pageable);

    int getTotalStudents();
}
