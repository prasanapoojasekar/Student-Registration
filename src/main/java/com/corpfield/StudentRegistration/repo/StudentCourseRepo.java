package com.corpfield.StudentRegistration.repo;

import com.corpfield.StudentRegistration.entity.StudentCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentCourseRepo extends JpaRepository<StudentCourse, Long> {

}
