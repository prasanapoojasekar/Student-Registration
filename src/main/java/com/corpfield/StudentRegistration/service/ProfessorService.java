package com.corpfield.StudentRegistration.service;

import com.corpfield.StudentRegistration.dto.CreateProfessorReqDto;
import com.corpfield.StudentRegistration.dto.ListProfessorResDto;
import com.corpfield.StudentRegistration.dto.responseDto.ResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProfessorService {
    void createProfessorDetails(CreateProfessorReqDto requestDto);
    ResponseDto getPagedProfessorsList(Pageable pageable);
}
