package com.corpfield.StudentRegistration.repo;

import com.corpfield.StudentRegistration.entity.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepo extends JpaRepository<Professor,Long> {
}
