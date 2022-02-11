package com.corpfield.StudentRegistration.dao;

import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CourseDao {
    List<Object[]> getCourseWith(Pageable pageable);

    int getTotalCourse();


    List<Object[]>getCourseWithProfessorId(Pageable pageable, long professorId);

    int getTotalCourseById(long professorId);

}
