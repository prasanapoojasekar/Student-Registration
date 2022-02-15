package com.corpfield.StudentRegistration.controller;

import com.corpfield.StudentRegistration.constants.CommonConstants;
import com.corpfield.StudentRegistration.dto.CreateCourseReqDto;
import com.corpfield.StudentRegistration.dto.ListCourseResDto;
import com.corpfield.StudentRegistration.dto.responseDto.ResponseDto;
import com.corpfield.StudentRegistration.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CourseController {

    @Autowired
    CourseService myCourseService;

    @PostMapping("/course")
    public ResponseEntity<String>createCourseDetails(@RequestBody CreateCourseReqDto reqDto){
        myCourseService.createCourseDetails(reqDto);
        return new ResponseEntity<>("Course details created successfully", HttpStatus.OK);
    }

    @GetMapping("/course")
    public ResponseEntity<ResponseDto> getPagedCourseList(
            @PageableDefault(size = CommonConstants.DEFAULT_PAGE_SIZE) Pageable pageable
    ){
        ResponseDto course = myCourseService.getPagedCourseList(pageable);
        return new ResponseEntity<>(course, HttpStatus.valueOf(course.getStatus()));
    }

    @GetMapping("/course/{professorId}")
    public ResponseEntity<ResponseDto> getCourseByProfessorId(
            @PageableDefault(size = CommonConstants.DEFAULT_PAGE_SIZE) Pageable pageable,
            @RequestParam("professor_id")long professorId
    ){
        ResponseDto response = myCourseService.getCourseByProfessorId(pageable,professorId);
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getStatus()));
    }

}


