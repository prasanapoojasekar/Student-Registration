package com.corpfield.StudentRegistration.Service;

import com.corpfield.StudentRegistration.Dto.CreateProfessorReqDto;
import com.corpfield.StudentRegistration.Dto.ListProfessorResDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProfessorService {
    void createProfessorDetails(CreateProfessorReqDto requestDto);

    Page<ListProfessorResDto> getPagedProfessorsList(Pageable pageable);
}
