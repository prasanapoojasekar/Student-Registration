package com.corpfield.StudentRegistration.repo;

import com.corpfield.StudentRegistration.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<Student,Long> {
}
