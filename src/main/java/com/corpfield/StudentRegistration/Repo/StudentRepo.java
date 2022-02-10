package com.corpfield.StudentRegistration.Repo;

import com.corpfield.StudentRegistration.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<Student,Long> {
}
