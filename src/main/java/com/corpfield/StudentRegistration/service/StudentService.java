package com.corpfield.StudentRegistration.service;

import com.corpfield.StudentRegistration.dto.ListStudentResDto;
import com.corpfield.StudentRegistration.dto.StudentCreateReqDto;
import com.corpfield.StudentRegistration.dto.responseDto.ResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StudentService {

    void createStudent(StudentCreateReqDto reqDto);

    ResponseDto getPagedStudentsList(Pageable pageable);
}
