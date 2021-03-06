package com.corpfield.StudentRegistration.dao;

import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProfessorDao {
    List<Object[]> getProfessorWith(Pageable pageable);

    int getTotalProfessors();
}
