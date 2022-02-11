package com.corpfield.StudentRegistration.service;

import com.corpfield.StudentRegistration.dto.CreateCourseReqDto;
import com.corpfield.StudentRegistration.dto.ListCourseResDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CourseService {
    void createCourseDetails(CreateCourseReqDto reqDto);

    Page<ListCourseResDto> getPagedCourseList(Pageable pageable);
}
