package com.corpfield.StudentRegistration.controller;

import com.corpfield.StudentRegistration.dto.CreateStudentCourseReqDto;
import com.corpfield.StudentRegistration.dto.ListStudentCourseResDto;
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
        return  new ResponseEntity<>("OK", HttpStatus.OK);
    }
    @GetMapping("/studentCourse")
    public ResponseEntity<Page<ListStudentCourseResDto>>getPagedStudentCourseList(
            @PageableDefault(size = 5) Pageable pageable
    ){
        Page<ListStudentCourseResDto> studentCourse = myStudentCourseService.getPagedStudentCourseList(pageable);
        return new ResponseEntity<>(studentCourse, HttpStatus.OK);
    }
    @GetMapping("/studentCourse/{studentId}")
    public  ResponseEntity<Page<ListStudentCourseResDto>>getStudentCourseByStudentId(
            @PageableDefault(size = 5) Pageable pageable,
            @RequestParam("student_id")long studentId
    ){
        Page<ListStudentCourseResDto> studentCourse = myStudentCourseService.getStudentCourseByStudentId(pageable,studentId);
        return  new ResponseEntity<>(studentCourse, HttpStatus.OK);
    }
}
