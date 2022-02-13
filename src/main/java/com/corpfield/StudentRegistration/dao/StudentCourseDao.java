package com.corpfield.StudentRegistration.dao;

import org.springframework.data.domain.Pageable;

import java.util.List;

public interface StudentCourseDao  {
    List<Object[]> getStudentCourseWith(Pageable pageable);

    int getTotalStudentCourse();
}
