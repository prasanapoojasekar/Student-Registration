package com.corpfield.StudentRegistration.controller;

import com.corpfield.StudentRegistration.constants.CommonConstants;
import com.corpfield.StudentRegistration.dto.CreateStudentCourseReqDto;
import com.corpfield.StudentRegistration.dto.ListStudentCourseResDto;
import com.corpfield.StudentRegistration.dto.responseDto.ResponseDto;
import com.corpfield.StudentRegistration.service.StudentCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentCourseController {

    @Autowired
    StudentCourseService myStudentCourseService;

    @PostMapping("/studentCourse")
    public ResponseEntity<String>createStudentCourse(@RequestBody CreateStudentCourseReqDto reqDto){
        myStudentCourseService.createStudentCourse(reqDto);
        return  new ResponseEntity<>("studentCourse details created successfully", HttpStatus.OK);
    }
    @GetMapping("/studentCourse")
    public ResponseEntity<ResponseDto>getPagedStudentCourseList(
            @PageableDefault(size =CommonConstants.DEFAULT_PAGE_SIZE) Pageable pageable
    ){
        ResponseDto studentCourse = myStudentCourseService.getPagedStudentCourseList(pageable);
        return new ResponseEntity<>(studentCourse, HttpStatus.valueOf(studentCourse.getStatus()));
    }
    @GetMapping("/studentCourse/{studentId}")
    public  ResponseEntity<ResponseDto>getStudentCourseByStudentId(
            @PageableDefault(size = CommonConstants.DEFAULT_PAGE_SIZE) Pageable pageable,
            @RequestParam("student_id")long studentId
    ){
        ResponseDto response = myStudentCourseService.getStudentCourseByStudentId(pageable,studentId);
        return  new ResponseEntity<>(response, HttpStatus.valueOf(response.getStatus()));
    }
}
