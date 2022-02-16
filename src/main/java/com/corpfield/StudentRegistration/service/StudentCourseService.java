package com.corpfield.StudentRegistration.service;

import com.corpfield.StudentRegistration.dto.CreateStudentCourseReqDto;
import com.corpfield.StudentRegistration.dto.responseDto.ResponseDto;
import org.springframework.data.domain.Pageable;

public interface StudentCourseService {
    void createStudentCourse(CreateStudentCourseReqDto reqDto);

    ResponseDto getPagedStudentCourseList(Pageable pageable);

    ResponseDto getStudentCourseByStudentId(Pageable pageable, long studentId);

}
