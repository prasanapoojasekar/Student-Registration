package com.corpfield.StudentRegistration.service;

import com.corpfield.StudentRegistration.dto.CreateCourseReqDto;
import com.corpfield.StudentRegistration.dto.ListCourseResDto;
import com.corpfield.StudentRegistration.dto.ListProfessorResDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CourseService {
    void createCourseDetails(CreateCourseReqDto reqDto);

    Page<ListCourseResDto> getPagedCourseList(Pageable pageable);

    Page<ListCourseResDto> getCourseByProfessorId(Pageable pageable,long professorId);

}
