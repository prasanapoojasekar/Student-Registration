package com.corpfield.StudentRegistration.service;

import com.corpfield.StudentRegistration.dto.CreateProfessorReqDto;
import com.corpfield.StudentRegistration.dto.ListProfessorResDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProfessorService {
    void createProfessorDetails(CreateProfessorReqDto requestDto);

    Page<ListProfessorResDto> getPagedProfessorsList(Pageable pageable);
}
