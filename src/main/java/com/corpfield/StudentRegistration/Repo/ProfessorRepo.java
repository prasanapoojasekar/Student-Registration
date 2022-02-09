package com.corpfield.StudentRegistration.Repo;

import com.corpfield.StudentRegistration.Entity.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepo extends JpaRepository<Professor,Long> {
}
