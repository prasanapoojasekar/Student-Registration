package com.corpfield.StudentRegistration.service;

import com.corpfield.StudentRegistration.dto.CreateCourseReqDto;
import com.corpfield.StudentRegistration.dto.ListCourseResDto;
import com.corpfield.StudentRegistration.dto.ListProfessorResDto;
import com.corpfield.StudentRegistration.dto.responseDto.ResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CourseService {
    void createCourseDetails(CreateCourseReqDto reqDto);

    ResponseDto getPagedCourseList(Pageable pageable);

    ResponseDto getCourseByProfessorId(Pageable pageable, long professorId);

}
