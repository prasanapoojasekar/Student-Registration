package com.corpfield.StudentRegistration.service;

import com.corpfield.StudentRegistration.dto.ListStudentResDto;
import com.corpfield.StudentRegistration.dto.StudentCreateReqDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface StudentService {

    void createStudent(StudentCreateReqDto reqDto);

    Page<ListStudentResDto> getPagedStudentsList(Pageable pageable);
}
